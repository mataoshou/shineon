package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.constant.ConvertsConstant;
import com.shineon.coder.kernel.constant.ServerConstant;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FeignBuild {

    Logger log = LoggerFactory.getLogger(getClass());
    public void build(String feignName,String serverName) throws IOException {
        feignName = ClassBuildUtil.getFileName(feignName);

        String className = ClassBuildUtil.firstUpper(feignName) +"Feign";
        String fallbackName = ClassBuildUtil.firstUpper(feignName) +"FeignFallBack";

        String constantName = ClassBuildUtil.firstUpper(feignName) +"FeignConstant";

        String sys = System.getProperty("user.dir");
        File coder = new File(sys, "src\\main\\java\\");

        ///////////////////////只生成一次，判断是否生成过
        File constantRoot = new File(coder, FeignConstant.FEIGN_CONSTANT_PACKAGE.replace(".","\\"));
        File constantFile =new File(constantRoot,constantName+".java");
        if(constantFile.exists())
        {
            log.info(constantFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }

        File feignRoot = new File(coder, FeignConstant.FEIGN_PACKAGE.replace(".","\\"));
        File feignFile =new File(feignRoot,className+".java");

        File fallBackFile = new File(feignRoot,fallbackName+".java");
        if(feignFile.exists())
        {
            log.info(feignFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }
        if(fallBackFile.exists())
        {
            log.info(fallBackFile.getPath() + "存在同名常量文件，请确认！！！");
            return;
        }


        ////////////////////////////////构建常量
        log.info("常量存储路径" + constantFile.getPath());

        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(constantName,null,null, FeignConstant.FEIGN_CONSTANT_PACKAGE,null,true,null);

        constantClassBuild.addTabContent("\r\n");
        constantClassBuild.addTabContent(String.format("public static final String FEIGN_SERVER_NAME =\"%s\";",serverName));
        for(String method: ActionConstant.ACTION_METHOD)
        {
            constantClassBuild.addTabContent("\r\n");
            constantClassBuild.addTabContent(String.format("public static final String FEIGN_%s =\"/%s/%s\";",
                    method.toUpperCase(),feignName,method.toLowerCase()));
        }

        constantClassBuild.finish(constantFile);

        ///////////////构建Feign  文件

        ClassBuildUtil feignClassBuild = new ClassBuildUtil();


        feignClassBuild.classInit(className,null,null, FeignConstant.FEIGN_PACKAGE
                ,new String[]{String.format("FeignClient(name = %s.FEIGN_SERVER_NAME,fallback = %s.class)",constantName,fallbackName),},
                false,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.cloud.openfeign.FeignClient",
                "org.springframework.web.bind.annotation.RequestMapping",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +constantName);

        for(String method: FeignConstant.FEIGN_METHOD)
        {
            feignClassBuild.addTabContent("\r\n");
            feignClassBuild.addTabContent(String.format("@RequestMapping(%s. FEIGN_%s)",constantName,method.toUpperCase()));
            feignClassBuild.addTabContent(String.format("CommonItem %s(CommonItem item);",method.toLowerCase()));
        }
        feignClassBuild.finish(feignFile);


        ///////////////构建FeignFallBack  文件

        ClassBuildUtil backClassBuild = new ClassBuildUtil();


        backClassBuild.classInit(fallbackName,null,new String[]{className,"BaseFallBack"}, FeignConstant.FEIGN_PACKAGE
                ,new String[]{"Component","Slf4j"},
                true,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.stereotype.Component",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +constantName);

        for(String method: FeignConstant.FEIGN_METHOD)
        {
            backClassBuild.addTabContent("\r\n");
            backClassBuild.addTabContent(String.format("@Override"));
            backClassBuild.addTabContent(String.format("public CommonItem %s(CommonItem item){return fail(%s.FEIGN_SERVER_NAME);}",method.toLowerCase(),constantName));
        }
        backClassBuild.finish(fallBackFile);
    }

    public static void main(String[] args) throws IOException {
        FeignBuild feignBuild =new FeignBuild();
        feignBuild.build("matao", ServerConstant.SHINEON_DB_USER);
    }
}
