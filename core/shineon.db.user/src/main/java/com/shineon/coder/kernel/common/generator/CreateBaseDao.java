package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.BaseFileUtil;
import com.shineon.coder.kernel.util.FileStore;

import java.io.File;
import java.io.IOException;

public class CreateBaseDao extends ICreateBase {
    public CreateBaseDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }


    @Override
    protected void createClass() throws IOException {

        String mapperFileName = this.name + "Mapper";
        File daoFile = new File(this.classFile.getParent() ,mapperFileName+".java");

        String content = FileStore.getContent(daoFile, "UTF-8");
        content = content.replace(mapperFileName, this.getClassName());
        FileStore.putString(this.classFile, content, "UTF-8");

        BaseFileUtil.delete(daoFile);
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
        return DBConstant.DB_DAO_PACKAGE;
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
        return this.name+"MapperBase";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

    @Override
    public void isRewrite(boolean rewrite) {
        super.isRewrite(true);
    }
}
