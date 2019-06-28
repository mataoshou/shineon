package com.shineon.coder;

import java.io.File;

public class ProjectInit {


    String[] classPaths =new String[]
            {
              "controller",
//                    "db/dao","db/mapper", "db/pojo",
                    "server","tool/common", "tool/convert",
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
        ProjectInit init = new ProjectInit();
        init.initPackage();
    }
}
