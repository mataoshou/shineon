package com.shineon.coder.kernel.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ClassMethodAppend {

    String header ="";
    String content ="";
    public ClassMethodAppend(File file) throws IOException {
        String classText = FileStore.getContent(file,"UTF-8");//.replace("\r","").replace("\n","");
//        classText ="{111111111111111}";
        String pattern_class ="([\\s\\S]*?)\\{([\\s\\S]*)}";

        Pattern pattern = Pattern.compile(pattern_class);
        Matcher matcher = pattern.matcher(classText);
        while (matcher.find()) {
            header = matcher.group(1).trim();
            System.out.println("............."+header);
            content = matcher.group(2).trim();

            System.out.println("............."+content);
        }

    }

    String packageName ="";

    List<String> imports =new ArrayList();

    String className = "";

    boolean isClass =true;

    String extendsName ="";
    List<String> getImplements = new ArrayList();


    public void init()
    {

    }

    public static void main(String[] args) throws IOException {
        ClassMethodAppend append = new ClassMethodAppend(new File("E:\\shineon.frame\\shineon\\core\\shineon.db.user\\src\\main\\java\\com\\shineon\\coder\\kernel\\util\\StringUtil.java"));

    }

}
