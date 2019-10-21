package com.shineon.coder.kernel.common.action;

import com.shineon.coder.db.sql.pojo.ShineonUser;
import com.shineon.coder.kernel.constant.ConvertsConstant;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ActionBuild {

    public void build(String actionName,Class convertClass,Class pojoClass) throws IOException {
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

        for(String method: ActionConstant.ACTION_METHOD)
        {
            constantClassBuild.addTabContent("\r\n");
            constantClassBuild.addTabContent(String.format("public static final String ACTION_%s =\"/%s/%s\";",
                    method.toUpperCase(),actionName,method.toLowerCase()));
        }

        constantClassBuild.finish(constantFile);


        //////////////构建 dto 文件

        ClassBuildUtil dtoClassBuild = new ClassBuildUtil();

        dtoClassBuild.classInit(dtoName,convertClass.getSimpleName(),null, ActionConstant.ACTION_DTO_PACKAGE,
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",convertClass.getName(),
                "lombok.extern.slf4j.Slf4j",pojoClass.getName(),"org.springframework.beans.factory.annotation.Autowired",
                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign");

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%sFeign service;",baseName));

        for(String method: ActionConstant.ACTION_METHOD)
        {
            dtoClassBuild.addTabContent("\r\n");
            dtoClassBuild.addTabContent(String.format("public %s %s(){return null;}",pojoClass.getSimpleName(),method.toLowerCase()));
        }

        dtoClassBuild.finish(dtoFile);

        ///////////////构建action  文件

        ClassBuildUtil actionClassBuild = new ClassBuildUtil();


        actionClassBuild.classInit(className,convertClass.getSimpleName(),null, ActionConstant.ACTION_PACKAGE,new String[]{"RestController","Slf4j"},
                true,convertClass.getName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController","org.springframework.web.bind.annotation.RequestMapping",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName,ActionConstant.ACTION_CONSTANT_PACKAGE+"." +constantName);


        actionClassBuild.addTabContent("\r\n");
        actionClassBuild.addTabContent("@Autowired");
        actionClassBuild.addTabContent(String.format("%s dto;",dtoName));

        for(String method: ActionConstant.ACTION_METHOD)
        {
            actionClassBuild.addTabContent("\r\n");
            actionClassBuild.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)",constantName,method.toUpperCase()));
            actionClassBuild.addTabContent(String.format("public CommonItem %s(){return null;}",method.toLowerCase()));
        }
        actionClassBuild.finish(actionFile);

    }



    public static void main(String[] args) throws IOException {
        System.out.println(ActionBuild.class.getName());
        System.out.println(ActionBuild.class.getSimpleName());

        ActionBuild build = new ActionBuild();
        build.build("matao", ShineonUserCommonUtil.class, ShineonUser.class);
    }
}
