package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateExternDao extends ICreateBase {
    public CreateExternDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();
        classBuildUtil.classInit(this.getClassName(), "",null,this.packageName, null, false,
                String.format("%s.%s",DBConstant.DB_POJO_PACKAGE, this.name), "java.util.List","org.apache.ibatis.annotations.Param");
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" List<%s> list(@Param(\"where\") String where,@Param(\"order\") String order);", this.name));
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" %s selectByName(String name);", this.name));
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" int insertByCustomId(%s item);", this.name));
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
        return this.name+"MapperExtern";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
