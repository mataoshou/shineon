package com.shineon.coder.kernel.common.bo;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.bo.BOConstant;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateBO extends ICreate {
    public CreateBO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {

        ClassBuildUtil classBuildUtil = new ClassBuildUtil();
        classBuildUtil.classInit(this.getClassName(), null,null,this.getPackageName(),new String[]{"Repository"}
                ,true,"org.springframework.beans.factory.annotation.Autowired",
                "org.springframework.stereotype.Repository", DBConstant.DB_MERGEDAO_PACKAGE+"."+getMapperName(),
                this.getItem().getPojoClassFullName(),
                "java.util.List","com.shineon.coder.kernel.util.GuidUtil");

        return classBuildUtil;
    }

    private String getMapperName()
    {
        String mapperName = "I"+ this.getItem().getPojoClassName() +"Mapper";
        return mapperName;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("private %s mapper;",getMapperName()));
        classBuildUtil.addTabContent("\r");

        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("private GuidUtil guidUtil;"));

        classBuildUtil.addTabContent("\r");
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        if(methodName.indexOf("get")>=0) {
            classBuildUtil.addTabContent(String.format("public %s %s(String id){",this.getItem().getPojoClassName(),methodName));
            classBuildUtil.addTabRightContent("return mapper.selectByPrimaryKey(id);");
            classBuildUtil.addTabLeftContent("}");

        }
        else if(methodName.indexOf("delete")>=0)
        {
            classBuildUtil.addTabContent(String.format("public boolean %s(String id){",methodName));
            classBuildUtil.addTabRightContent("int count = mapper.deleteByPrimaryKey(id);");
            classBuildUtil.addTabContent("if(count>0) { return true; }");
            classBuildUtil.addTabContent("return false;");
            classBuildUtil.addTabLeftContent("}");
        }
        else if(methodName.indexOf("list")>=0)
        {
            classBuildUtil.addTabContent(String.format("public List<%s> %s() {",this.getItem().getPojoClassName(),methodName));

            classBuildUtil.addTabRightContent("return mapper.list(null,null);");
            classBuildUtil.addTabLeftContent("}");
        }
        else if(methodName.indexOf("insert")>=0){
            classBuildUtil.addTabContent(String.format("public %s %s(%s item){",this.getItem().getPojoClassName(),methodName,this.getItem().getPojoClassName()));

            classBuildUtil.addTabRightContent("String id = guidUtil.gen();");
            classBuildUtil.addTabContent("item.setId(id);");
            classBuildUtil.addTabContent("mapper.insertByCustomId(item);");
            classBuildUtil.addTabContent("return get(id);");
            classBuildUtil.addTabLeftContent("}");
        }
        else if(methodName.indexOf("update")>=0)
        {
            classBuildUtil.addTabContent(String.format("public %s %s(%s item){",this.getItem().getPojoClassName(),methodName,this.getItem().getPojoClassName()));

            classBuildUtil.addTabRightContent("mapper.updateByPrimaryKey(item);");
            classBuildUtil.addTabContent("return get(item.getId());");
            classBuildUtil.addTabLeftContent("}");
        }
        else{
            classBuildUtil.addTabContent(String.format("public %s %s(%s item){",this.getItem().getPojoClassName(),methodName,this.getItem().getPojoClassName()));
            classBuildUtil.addTabRightContent("return null;");
            classBuildUtil.addTabLeftContent("}");
        }
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
        return BOConstant.BO_PACKAGE;
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
        return "BO";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
