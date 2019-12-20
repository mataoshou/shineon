package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateDTO extends ICreateBase {

    public CreateDTO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil dtoClassBuild = new ClassBuildUtil();

        dtoClassBuild.classInit(this.getClassName(),null,null,this.packageName,
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",toolClass.getName(),
                "lombok.extern.slf4j.Slf4j",pojoClass.getName(),"org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                "com.shineon.coder.db.pojo.QueryItem",
                "com.shineon.coder.service.convert.util.QueryItemCommonUtil",
                "com.shineon.coder.service.convert.CommonItem",
                "java.util.List",String.format("%s.%sCache", CacheConstant.CACHE_PACKAGE,this.name) );

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("QueryItemCommonUtil queryItemCommonUtil;"));


        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%s commonUtil;",this.toolClassName));

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%sFeign feign;",this.name));


        for(String method: methods)
        {
            dtoClassBuild.addTabContent("\r\n");
            if(method.indexOf("list")>=0)
            {
                dtoClassBuild.addTabContent(String.format("public List<%s> %s(CommonItem item) throws Exception{",pojoClass.getSimpleName(),method.toLowerCase()));
            }
            else{
                dtoClassBuild.addTabContent(String.format("public %s %s(CommonItem item) throws Exception{",pojoClass.getSimpleName(),method.toLowerCase()));
            }
            dtoClassBuild.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));
            dtoClassBuild.addTabContent(String.format("return commonUtil.toPojo(feign.%s(item));",method.toLowerCase()));
            dtoClassBuild.addTabLeftContent(String.format("}"));
        }





        dtoClassBuild.finish(this.classFile);
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
        return ActionConstant.ACTION_DTO_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return "";
    }

    @Override
    protected String getClassName() {
        return this.name+"DTO";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

}
