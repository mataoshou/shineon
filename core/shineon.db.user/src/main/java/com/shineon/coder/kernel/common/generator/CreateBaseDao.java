package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.BaseFileUtil;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.kernel.util.FileStore;

import java.io.File;
import java.io.IOException;

public class CreateBaseDao extends ICreate {
    public CreateBaseDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }


    @Override
    protected ClassBuildUtil createClass() throws IOException {

        return null;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        String mapperFileName = this.getName() + "Mapper";
        File daoFile = new File(this.getClassFile().getParent() ,mapperFileName+".java");

        String content = FileStore.getContent(daoFile, "UTF-8");
        content = content.replace(mapperFileName, this.getClassName());
        FileStore.putString(this.getClassFile(), content, "UTF-8");

        BaseFileUtil.delete(daoFile);
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {

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
        this.setConver(true);
    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_DAO_PACKAGE;
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
        return "MapperBase";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
