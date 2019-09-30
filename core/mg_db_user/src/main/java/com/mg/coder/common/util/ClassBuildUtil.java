package com.mg.coder.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassBuildUtil {


    Logger logger = LoggerFactory.getLogger(ClassBuildUtil.class);

    String tab ="	";

    public String classInit(String className,String baseName,String packageName,String[] annotation,boolean isclass,String... imports)
    {
        String classStr ="";


        logger.info(String.format("开始构建类文件 %s 的 文件内容",className));

        String content = "";
        int tab_no=0;

        ////////添加packagename;
        content += getContent(tab_no,tab, String.format("package %s ;",packageName));
        content += getContent(tab_no,tab, String.format(""));
        /////////添加import
        for(String importName :imports) {
            content += getContent(tab_no, tab, String.format("import %s;", importName));
        }

        content += getContent(tab_no,tab, String.format(""));

        if(annotation!=null&&annotation.length>0)
        {
            for(String str : annotation) {
                content += getContent(tab_no, tab, String.format("@%s", str));
            }

        }

        ////////构建class内容
        String classType = "class";
        if(!isclass)
        {
            classType = "interface";
        }
        if(baseName!=null&&baseName.length()>0) {
            content += getContent(tab_no, tab, String.format("public %s %s extends %s {",classType, className, baseName));
        }
        else{
            content += getContent(tab_no, tab, String.format("public %s %s {", classType,className));
        }

        content += "##1\r\n";

        content += getContent(--tab_no,tab, String.format("}"));

        return content;
    }


    public void createFile(File file,String content) throws IOException {
        logger.info("开始生成文件：" + file.getPath());
        FileOutputStream out = new FileOutputStream(file);
        out.write(content.getBytes("UTF-8"));
        out.close();
        logger.info("文件生成成功！！");
    }

    int tab_no = 1;

    public String addContent(String content,String line)
    {
        content += getContent(tab_no,tab,line);

        return content;
    }
    public String addTabConent(String content,String line)
    {
        tab_no++;

        return addContent(content,line);
    }

    public String subTabConent(String content,String line)
    {
        tab_no--;

        return addContent(content,line);
    }


    //获取属性的get方法
    public String getGetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("get" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }
    //获取属性的set方法
    public String getSetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("set" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }

    public String getLName(String name)
    {
        char first = Character.toLowerCase(name.charAt(0));
        StringBuffer rName = new StringBuffer(name);
        rName.setCharAt(0, first);
        return  rName.toString();
    }

    public String getContent(int tab_no,String tab,String content)
    {
        String tabs="";
        for(int i=0;i<tab_no;i++)
        {
            tabs+=tab;
        }
        return tabs+content+"\r\n";
    }
}
