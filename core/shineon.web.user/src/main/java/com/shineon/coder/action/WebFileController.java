package com.shineon.coder.action;

import com.shineon.coder.kernel.util.BaseFileUtil;
import com.shineon.coder.kernel.util.FileStore;
import com.shineon.coder.kernel.util.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.RandomAccessFile;

@RestController
public class WebFileController {


    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/web/**")
    public void getFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /////////////////////构建文件路径
        String url = request.getRequestURI();

        logger.info(url);

        File root = new File(System.getProperty("user.dir"));

        File file = new File(root,url);

        logger.info(file.getPath());
        String fileName = file.getName();

        OutputStream out = response.getOutputStream();

        ///////////////////////////////文件是否可用验证
        if(!file.exists())
        {
            response.sendError(404,"no this page ,please check the url !!!");
            return;
        }


        if(!file.isFile())
        {
            response.sendError(404,"no this page ,please check the url !!!");
            return;
        }



        ///////////////////////文件类型判断
        String suffix = BaseFileUtil.getSuffix(fileName);

        String fileType = FileType.getType(suffix);

        String contentType =FileType.getContentBySuffix(suffix);

        logger.info(contentType);

        response.setContentType(contentType);

        /////////////////////////媒体文件
        if(fileType.equals(FileType.JPG)||fileType.equals(FileType.GIF)||fileType.equals(FileType.PNG)||fileType.equals(FileType.VIDEO))
        {
            logger.info("处理媒体文件");
            Range r = new Range();
            r.start =0;
            r.end = file.length()-1;
            sendFile(file,r,out);

        }
        ///////////////////文本文件
        else{
            logger.info("处理文本文件");
            String content = FileStore.getContent(file,"utf-8");

            out.write(content.getBytes("UTF-8"));
        }

    }



    private void sendFile(File f, Range r, OutputStream outstream)
            throws Exception
    {
        RandomAccessFile instream = new RandomAccessFile(f, "r");
        long contentLength = r.end - r.start + 1;
        byte[] buffer = new byte[24 * 1024];
        long numOfBytes = 0;
        long numOfSent = 0;
        // TODO: 不支持long? 那大于2G的文件怎么下载?

        try
        {
            if (r.start > 0)
                instream.seek(r.start);

            while (numOfSent < contentLength)
            {
                // 从源文件中读取数据: 不要多读数据, 否则Content-Length-Mismatch
                long want = contentLength - numOfSent;
                if(want > buffer.length) want = buffer.length;
                int n = instream.read(buffer, 0, (int)want);

                // 发送给客户端ClientAbortException
                try
                {
                    outstream.write(buffer, 0, n);
                } catch (Exception ex)
                {
                    // 不能发送给客户端，意味着网络出问题
                    break; // 结束发送
                }
                numOfSent += n;

                // 要不要sleep ?
                numOfBytes += n;
                if (numOfBytes > 1024 * 1024 * 1)
                {
                    try
                    {
                        Thread.sleep(5);
                    } catch (Exception e)
                    {
                    }
                    numOfBytes = 0;
                }
            }
            System.out.println(" 发送完成,numOfSent :"+numOfSent+",contentLength:"+contentLength);

        } finally
        {
            instream.close();
        }
    }


    class Range
    {
        public long start = -1;
        public long end = -1;
    }

}
