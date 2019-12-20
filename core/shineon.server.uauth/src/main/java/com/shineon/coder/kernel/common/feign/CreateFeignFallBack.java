package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateFeignFallBack extends ICreateBase {
    public CreateFeignFallBack(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil backClassBuild = new ClassBuildUtil();


        String feignName = this.name +"Feign";

        String feignConstant =this.name + "FeignConstant";

        backClassBuild.classInit(this.getClassName(),null,new String[]{feignName,"BaseFallBack"}, this.packageName
                ,new String[]{"Component","Slf4j"},
                true,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.stereotype.Component",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +feignConstant);

        for(String method: methods)
        {
            backClassBuild.addTabContent("\r\n");
            backClassBuild.addTabContent(String.format("@Override"));
            backClassBuild.addTabContent(String.format("public CommonItem %s(CommonItem item){return fail(%s.FEIGN_SERVER_NAME);}",method.toLowerCase(),feignConstant));
        }
        backClassBuild.finish(this.classFile);
    }

    @Override
    protected void createConstant() throws IOException {

    }

    @Override
    protected boolean checkBeforBuild() {
        return true;
    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return null;
    }

    @Override
    protected String getClassName() {
        return this.name +"FeignFallBack";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
