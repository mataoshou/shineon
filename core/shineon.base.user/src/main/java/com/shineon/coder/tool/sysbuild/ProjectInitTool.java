package com.shineon.coder.tool.sysbuild;

import java.io.File;

public class ProjectInitTool {


    String[] classPaths =new String[]
            {
                    "action",
                    "db",
                    "config",
                    "tool/build",
                    "kernel",
                    "service",
                    "version"
            };


    public void initPackage()
    {
        String root = System.getProperty("user.dir");
        File f = new File(root,"src\\main\\java\\com\\shineon\\coder");
        System.out.println(f.getPath());

        for(String path:classPaths)
        {
            File pg = new File(f,path);

            pg.mkdirs();
            System.out.println("构建路径："+pg.getPath());
        }
    }

    public static  void main(String[] args)
    {
        ProjectInitTool init = new ProjectInitTool();
        init.initPackage();
    }
}
