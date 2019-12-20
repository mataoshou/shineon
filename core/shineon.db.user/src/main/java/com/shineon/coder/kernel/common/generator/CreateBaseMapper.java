package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.BaseFileUtil;
import com.shineon.coder.kernel.util.FileStore;

import java.io.File;
import java.io.IOException;

public class CreateBaseMapper extends ICreateBase {
    public CreateBaseMapper(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        String mapperFileName = this.name + "Mapper";

        String mergeFileName = "I" + this.name + "Mapper";

        File mapperFile = new File(this.classFile.getParent(), mapperFileName + ".xml");
        String content = FileStore.getContent(mapperFile, "UTF-8");
        content = content.replace(mapperFileName, mergeFileName).replace("dao", "mergedao");
        FileStore.putString(this.classFile, content, "UTF-8");

        BaseFileUtil.delete(mapperFile);
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
        return DBConstant.DB_MAPPER_PACKAGE;
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
        return this.name +"MapperBase";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

    @Override
    protected String getSuffix() {
        return "xml";
    }


    @Override
    public void isRewrite(boolean rewrite) {
        super.isRewrite(true);
    }
}
