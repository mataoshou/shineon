package com.shineon.coder.kernel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassBuildUtil {


    Logger logger = LoggerFactory.getLogger(ClassBuildUtil.class);

    int tab_no=0;
    String tab ="	";

    String classConetent;

    /**
     * 初始化class类
     * @param className  类名
     * @param baseName 接口和父类
     * @param packageName 包名
     * @param annotation 注解
     * @param isclass 是否为class  false 为接口
     * @param imports  import内容
     */
    public void classInit(String className,String baseName,String packageName,String[] annotation,boolean isclass,String... imports)
    {
        String classStr ="";


        logger.info(String.format("开始构建类文件 %s 的 文件内容",className));

        String content = "";


        ////////添加packagename;
        content += getContent(tab_no,tab, String.format("package %s ;",packageName));
        content += getContent(tab_no,tab, String.format(""));
        /////////添加import
        if(imports!=null&&imports.length>0) {
            for (String importName : imports) {
                content += getContent(tab_no, tab, String.format("import %s;", importName));
            }
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

        content += "##1\r";

        content += getContent(tab_no,tab, String.format("}"));

        classConetent = content;

        tab_no++;
    }


    String innerContent = "";


    /**
     * 完成 并返回class文本内容
     * @return
     */
    public String finish()
    {
        classConetent = classConetent.replace("##1",innerContent);
        return classConetent;
    }
    /**
     * 完成 并将内容写入文件
     * @return
     */
    public void finish(File file) throws IOException {
        finish();
        logger.info("开始生成文件：" + file.getPath());
        file.getParentFile().mkdirs();
        FileOutputStream out = new FileOutputStream(file);
        out.write(classConetent.getBytes("UTF-8"));
        out.close();
        logger.info("文件生成成功！！");
    }


    /**
     * tab 间隔不变  增加类内容
     * @param line
     */
    public void  addTabContent(String line)
    {
        innerContent += getContent(tab_no,tab,line);
    }


    /**
     * tab 间隔加1  增加类内容
     * @param line
     */
    public void addTabRightContent(String line)
    {
        tab_no++;

        addTabContent(line);
    }
    /**
     * tab 间隔减1  增加类内容
     * @param line
     */
    public void addTabLeftContent(String line)
    {
        tab_no--;

        addTabContent(line);
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

    private String getContent(int tab_no,String tab,String content)
    {
        String tabs="";
        for(int i=0;i<tab_no;i++)
        {
            tabs+=tab;
        }
        return tabs+content+"\r";
    }
}
