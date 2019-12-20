package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateMergeDao extends ICreateBase {
    public CreateMergeDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        String mapperBaseFileName = this.name +"MapperBase";
        String mapperExternFileName = this.name +"MapperExtern";
        classBuildUtil.classInit(this.getClassName(), mapperBaseFileName + "," + mapperExternFileName,null, this.packageName, null, false,
                DBConstant.DB_DAO_PACKAGE+"." + mapperBaseFileName, DBConstant.DB_DAO_PACKAGE+"." + mapperExternFileName);

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
        return DBConstant.DB_MERGEDAO_PACKAGE;
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
        return "I"+this.name +"Mapper";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
