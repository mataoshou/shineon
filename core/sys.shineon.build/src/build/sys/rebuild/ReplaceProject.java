package build.sys.rebuild;

import build.tool.FileStore;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class ReplaceProject {



//    private File root =  new File("E:\\mg.frame\\core\\");

    public void replaceName(String[] sourceName,String[] dstName,String sysName,File rootFile) throws Exception {
        File sysFile = new File(rootFile,sysName+"");
        for (int i = 0; i < sourceName.length; i++) {
            replaceName(sourceName[i], dstName[i],sysName,sysFile);
        }
    }


    public void replaceName(String source,String dst,String sysName,File sysFile) throws Exception {
        if(!sysFile.exists())
        {
            System.out.println(sysFile.getPath() + "系统路径不存在，请检查！！");
            return;
        }

        if(sysFile.isDirectory())
        {
            File[] fs = sysFile.listFiles();

            for(File f :fs) {
                replaceName(source, dst, sysName, f);
            }

            if(sysFile.getName().equals(source))
            {
                FileUtils.moveDirectory(sysFile,new File(sysFile.getParent(),dst));
            }
        }

        if(sysFile.isFile())
        {
            String content =  FileStore.getContent(sysFile);
            content = content.replace(source,dst);
            FileStore.putString(sysFile,content);

            System.out.println(String.format("%s已经替换完成[%s]-->[%s]！",sysFile.getPath(),source,dst ));
        }
    }
}
