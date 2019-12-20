package com.shineon.coder.kernel.common.convert;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateConvertUtil extends ICreateBase {
    public CreateConvertUtil(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        String baseName = this.name + "CommonBase";

        classBuildUtil.classInit(this.getClassName(),baseName, null, this.packageName ,new String[]{"Service"},true,
                String.format("%s.%s", ConvertsConstant.BASE_PACKAGE,baseName),"org.springframework.stereotype.Service");


        classBuildUtil.finish(this.classFile);
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
        return ConvertsConstant.UTIL_PACKAGE;
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
        return this.name +"CommonUtil";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
