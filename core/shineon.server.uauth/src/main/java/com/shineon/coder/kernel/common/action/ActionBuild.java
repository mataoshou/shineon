package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ActionBuild {

    Logger log = LoggerFactory.getLogger(getClass());

    public void build(String actionName,Class convertClass,Class pojoClass) throws IOException {
        build(actionName,convertClass,pojoClass,ActionConstant.ACTION_METHOD);
    }

    public void build(String actionName,Class convertClass,Class pojoClass,String[] methods) throws IOException {
        if(actionName.endsWith(".java"))
        {
            actionName = ClassBuildUtil.getFileName(actionName);
        }

        String baseName = ClassBuildUtil.firstUpper(actionName);

        String dtoName = baseName+"DTO";
        String className = baseName +"Controller";
        String constantName = baseName +"ActionConstant";


        String sys = System.getProperty("user.dir");
        File coder = new File(sys, "src\\main\\java\\");

        ///////////////////////只生成一次，判断是否生成过
        File constantRoot = new File(coder, ActionConstant.ACTION_CONSTANT_PACKAGE.replace(".","\\"));
        File constantFile =new File(constantRoot,constantName+".java");
        if(constantFile.exists())
        {
            log.info(constantFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }

        File actionRoot = new File(coder, ActionConstant.ACTION_PACKAGE.replace(".","\\"));
        File actionFile =new File(actionRoot,className+".java");
        if(actionFile.exists())
        {
            log.info(actionFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }

        File dtoRoot = new File(coder, ActionConstant.ACTION_DTO_PACKAGE.replace(".","\\"));
        File dtoFile =new File(dtoRoot,dtoName+".java");

        if(dtoFile.exists())
        {
            log.info(dtoFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }

        //////////////构建 constant文件


        log.info("常量存储路径" + constantFile.getPath());

        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(constantName,null,null, ActionConstant.ACTION_CONSTANT_PACKAGE,null,true,null);

        for(String method: methods)
        {
            constantClassBuild.addTabContent("\r\n");
            constantClassBuild.addTabContent(String.format("public static final String ACTION_%s =\"/%s/%s\";",
                    method.toUpperCase(),actionName,method.toLowerCase()));
        }

        constantClassBuild.finish(constantFile);


        //////////////构建 dto 文件

        ClassBuildUtil dtoClassBuild = new ClassBuildUtil();

        dtoClassBuild.classInit(dtoName,null,null, ActionConstant.ACTION_DTO_PACKAGE,
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",convertClass.getName(),
                "lombok.extern.slf4j.Slf4j",pojoClass.getName(),"org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                "com.shineon.coder.db.pojo.QueryItem",
                "com.shineon.coder.service.convert.util.QueryItemCommonUtil",
                "com.shineon.coder.service.convert.CommonItem",
                "java.util.List");

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("QueryItemCommonUtil queryItemCommonUtil;"));

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%sFeign feign;",baseName));


        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%s commonUtil;",convertClass.getSimpleName()));

        for(String method: methods)
        {
            dtoClassBuild.addTabContent("\r\n");
            if(method.indexOf("list")>=0)
            {
                dtoClassBuild.addTabContent(String.format("public List<%s> %s(CommonItem item) throws Exception{",pojoClass.getSimpleName(),method.toLowerCase()));
            }
            else{
                dtoClassBuild.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",pojoClass.getSimpleName(),method.toLowerCase()));
            }
            dtoClassBuild.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            dtoClassBuild.addTabContent(String.format("return commonUtil.toPojo(feign.%s(item));",method.toLowerCase()));
            dtoClassBuild.addTabLeftContent(String.format("}"));
        }

        dtoClassBuild.finish(dtoFile);

        ///////////////构建action  文件

        ClassBuildUtil actionClassBuild = new ClassBuildUtil();


        actionClassBuild.classInit(className,null
                ,null, ActionConstant.ACTION_PACKAGE,new String[]{"RestController","Slf4j"},
                true,convertClass.getName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController","org.springframework.web.bind.annotation.RequestMapping",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName, ActionConstant.ACTION_CONSTANT_PACKAGE+"." +constantName
                ,"org.springframework.web.bind.annotation.RequestBody");


        actionClassBuild.addTabContent("\r\n");
        actionClassBuild.addTabContent("@Autowired");
        actionClassBuild.addTabContent(String.format("%s dto;",dtoName));

        actionClassBuild.addTabContent("\r\n");
        actionClassBuild.addTabContent("@Autowired");
        actionClassBuild.addTabContent(String.format("%s commonUtil;",convertClass.getSimpleName()));



        for(String method: methods)
        {
            actionClassBuild.addTabContent("\r\n");
            actionClassBuild.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)",constantName,method.toUpperCase()));
            actionClassBuild.addTabContent(String.format("public CommonItem %s(@RequestBody CommonItem item) throws Exception{",method.toLowerCase()));
            actionClassBuild.addTabRightContent(String.format("return commonUtil.toCommon(dto.%s(item));",method.toLowerCase()));
            actionClassBuild.addTabLeftContent(String.format("}"));
        }
        actionClassBuild.finish(actionFile);

    }



//    public static void main(String[] args) throws IOException {
//        System.out.println(ActionBuild.class.getName());
//        System.out.println(ActionBuild.class.getSimpleName());
//
//        ActionBuild build = new ActionBuild();
//        build.build("matao", RmtUserInfoCommonUtil.class, RmtUserInfo.class);
//    }
}
