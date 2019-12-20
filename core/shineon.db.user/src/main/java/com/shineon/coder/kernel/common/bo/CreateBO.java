package com.shineon.coder.kernel.common.bo;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.bo.BOConstant;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateBO extends ICreateBase {
    public CreateBO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {

        String mapperName = "I"+ this.pojoClass.getSimpleName() +"Mapper";

        ClassBuildUtil classBuildUtil = new ClassBuildUtil();
        classBuildUtil.classInit(this.getClassName(), null,null,this.packageName,new String[]{"Repository"}
                ,true,"org.springframework.beans.factory.annotation.Autowired",
                "org.springframework.stereotype.Repository", DBConstant.DB_MERGEDAO_PACKAGE+"."+mapperName,
                DBConstant.DB_POJO_PACKAGE+"."+pojoClass.getSimpleName(),
                "java.util.List","com.shineon.coder.kernel.util.GuidUtil");


        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("private %s mapper;",mapperName));
        classBuildUtil.addTabContent("\r");

        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("private GuidUtil guidUtil;"));

        classBuildUtil.addTabContent("\r");

        for(String method :BOConstant.BO_METHOD)
        {

            if(method.indexOf("get")>=0) {
                classBuildUtil.addTabContent(String.format("public %s %s(String id){",pojoClass.getSimpleName(),method));
                classBuildUtil.addTabRightContent("return mapper.selectByPrimaryKey(id);");
                classBuildUtil.addTabLeftContent("}");

            }
            else if(method.indexOf("delete")>=0)
            {
                classBuildUtil.addTabContent(String.format("public boolean %s(String id){",method));
                classBuildUtil.addTabRightContent("int count = mapper.deleteByPrimaryKey(id);");
                classBuildUtil.addTabContent("if(count>0) { return true; }");
                classBuildUtil.addTabContent("return false;");
                classBuildUtil.addTabLeftContent("}");
            }
            else if(method.indexOf("list")>=0)
            {
                classBuildUtil.addTabContent(String.format("public List<%s> %s() {",pojoClass.getSimpleName(),method));

                classBuildUtil.addTabRightContent("return mapper.list(null,null);");
                classBuildUtil.addTabLeftContent("}");
            }
            else if(method.indexOf("insert")>=0){
                classBuildUtil.addTabContent(String.format("public %s %s(%s item){",pojoClass.getSimpleName(),method,pojoClass.getSimpleName()));

                classBuildUtil.addTabRightContent("String id = guidUtil.gen();");
                classBuildUtil.addTabContent("item.setId(id);");
                classBuildUtil.addTabContent("mapper.insertByCustomId(item);");
                classBuildUtil.addTabContent("return get(id);");
                classBuildUtil.addTabLeftContent("}");
            }
            else if(method.indexOf("update")>=0)
            {
                classBuildUtil.addTabContent(String.format("public %s %s(%s item){",pojoClass.getSimpleName(),method,pojoClass.getSimpleName()));

                classBuildUtil.addTabRightContent("mapper.updateByPrimaryKey(item);");
                classBuildUtil.addTabContent("return get(item.getId());");
                classBuildUtil.addTabLeftContent("}");
            }
            else{
                classBuildUtil.addTabContent(String.format("public %s %s(%s item){",pojoClass.getSimpleName(),method,pojoClass.getSimpleName()));
                classBuildUtil.addTabRightContent("return null");
                classBuildUtil.addTabLeftContent("}");
            }



            classBuildUtil.addTabContent("\r");
        }

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
        return BOConstant.BO_PACKAGE;
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
        return this.name+"BO";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
