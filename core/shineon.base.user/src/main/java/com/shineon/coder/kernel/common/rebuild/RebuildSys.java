package com.shineon.coder.kernel.common.rebuild;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.constant.SysConstant;
import com.shineon.coder.kernel.util.FileStore;

import java.io.File;
import java.io.IOException;

/**
 * 重构系统使用
 */
public class RebuildSys {

    public void rebuild(String sysName) throws IOException {
        String src = SysConstant.CURRENT_SYS_NAME;

        CommonTool tool = new CommonTool();

        File constantRoot =  tool.getSysPath("com.shineon.coder.kernel.constant");

        File constantFile =new File(constantRoot,"SysConstant.java");

        replaceContent(constantFile,src,sysName);


        File ymlRoot  = new File(tool.getSysPath("").getParentFile(),"resources");

        File application = new File(ymlRoot,"application.yml");
        replaceContent(application,src,sysName);

    }

    public void replaceContent(File file,String src,String dst) throws IOException {
        String content = FileStore.getContent(file);

        content = content.replace(src,dst);

        FileStore.putString(file,content);
    }


    public static void main(String[] args) throws IOException {
        RebuildSys rebuildSys = new RebuildSys();
        rebuildSys.rebuild("shineon.db.user");
    }
}
