package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateDTO extends ICreate {

    public CreateDTO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil dtoClassBuild = new ClassBuildUtil();

        dtoClassBuild.classInit(this.getClassName(),null,null,this.getPackageName(),
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",this.getItem().getToolClassFullName(),
                "lombok.extern.slf4j.Slf4j",this.getItem().getToolClassFullName(),"org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                "com.shineon.coder.db.pojo.QueryItem",
                "com.shineon.coder.service.convert.util.QueryItemCommonUtil",
                "com.shineon.coder.service.convert.CommonItem",
                "java.util.List",String.format("%s.%sFeign", FeignConstant.FEIGN_PACKAGE,this.getName()) );

        return dtoClassBuild;
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
        classBuildUtil.addTabContent(String.format("%sFeign feign;",this.getName()));
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        if(methodName.indexOf("list")>=0)
        {
            classBuildUtil.addTabContent(String.format("public List<%s> %s(CommonItem item) throws Exception{",this.getItem().getToolClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format("return commonUtil.toPojoList(feign.%s(item));",methodName.toLowerCase()));
        }
        else{
            classBuildUtil.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",this.getItem().getToolClassName(),methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            classBuildUtil.addTabContent(String.format("return commonUtil.toPojo(feign.%s(item));",methodName.toLowerCase()));
        }
        classBuildUtil.addTabLeftContent(String.format("}"));
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
