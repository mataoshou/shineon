package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateFeignFallBack extends ICreate {
    public CreateFeignFallBack(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil backClassBuild = new ClassBuildUtil();


        String feignName = this.getName() +"Feign";

        String feignConstant =this.getName() + "FeignConstant";

        backClassBuild.classInit(this.getClassName(),null,new String[]{feignName,"BaseFallBack"}, this.getPackageName()
                ,new String[]{"Component","Slf4j"},
                true,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.stereotype.Component",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +feignConstant);

        return backClassBuild;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        String feignConstant =this.getName() + "FeignConstant";

        classBuildUtil.addTabContent(String.format("@Override"));
        classBuildUtil.addTabContent(String.format("public CommonItem %s(CommonItem item){return fail(%s.FEIGN_SERVER_NAME);}",methodName.toLowerCase(),feignConstant));

    }

    @Override
    protected void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected ClassBuildUtil createConstantClass() throws IOException {
        return null;
    }

    @Override
    protected void createConstantPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createConstantMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {

    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return null;
    }

    @Override
    protected String getClassNameLast() {
        return "FeignFallBack";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
