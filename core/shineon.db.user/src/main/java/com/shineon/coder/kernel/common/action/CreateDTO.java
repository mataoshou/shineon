package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.bo.BOConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateDTO extends ICreate {

    public CreateDTO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        classBuildUtil.classInit(this.getClassName(),null,null,this.getPackageName(),
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",this.getItem().getPojoClassFullName(),
                "lombok.extern.slf4j.Slf4j",this.getItem().getToolClassFullName(),"org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                "com.shineon.coder.db.pojo.QueryItem",
                "com.shineon.coder.service.convert.util.QueryItemCommonUtil",
                "com.shineon.coder.service.convert.CommonItem",
                "java.util.List",String.format("%s.%sBO", BOConstant.BO_PACKAGE,this.getName()));

        return classBuildUtil;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("QueryItemCommonUtil queryItemCommonUtil;"));

        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("%s commonUtil;",this.getItem().getToolClassName()));

        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("%sBO bo;",this.getName()));
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        if(methodName.indexOf("list")>=0)
        {
            classBuildUtil.addTabContent(String.format("public List<%s> %s(CommonItem item) throws Exception{",this.getItem().getPojoClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format("return bo.%s();",methodName));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("get")>=0)
        {
            classBuildUtil.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",this.getItem().getPojoClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format("%s result = bo.%s(query.getId());",this.getItem().getPojoClassFullName(),methodName));
            classBuildUtil.addTabContent(String.format(" if(result==null) throw new Exception(\"数据不存在！\");"));
            classBuildUtil.addTabContent(String.format("return result;"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("edit")>=0)
        {
            classBuildUtil.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",this.getItem().getPojoClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("%s pojo = commonUtil.toPojo(item);",this.getItem().getPojoClassFullName()));
            classBuildUtil.addTabContent(String.format("if(pojo.getId() ==null||pojo.getId().equals(\"0\")) {"));
            classBuildUtil.addTabRightContent(String.format("return bo.insert(pojo);"));
            classBuildUtil.addTabLeftContent(String.format("}"));
            classBuildUtil.addTabContent(String.format("else{ return bo.update(pojo); }"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("delete")>=0)
        {
            classBuildUtil.addTabContent(String.format("public void %s(CommonItem item) throws Exception{",methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format(" if(!bo.%s(query.getId())){",methodName));
            classBuildUtil.addTabRightContent(String.format("if(!bo.delete(query.getId())){"));
            classBuildUtil.addTabRightContent(String.format("throw new Exception(\"数据删除失败！！\");"));
            classBuildUtil.addTabLeftContent(String.format("}"));
            classBuildUtil.addTabLeftContent(String.format("}"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else
        {
            classBuildUtil.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",this.getItem().getPojoClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format("return null;"));
            classBuildUtil.addTabLeftContent(String.format("}"));
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
        return ActionConstant.ACTION_DTO_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return false;
    }


    @Override
    protected String getConstantPackageName() {
        return "";
    }


    @Override
    protected String getClassNameLast() {
        return "DTO";
    }


    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
