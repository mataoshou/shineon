package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateDTO extends ICreateBase {

    public CreateDTO(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil dtoClassBuild = new ClassBuildUtil();

        dtoClassBuild.classInit(this.getClassName(),null,null, ActionConstant.ACTION_DTO_PACKAGE,
                new String[]{"Service","Slf4j"},true,"org.springframework.stereotype.Service",this.toolClass.getName(),
                "lombok.extern.slf4j.Slf4j",pojoClass.getName(),"org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                "com.shineon.coder.db.pojo.QueryItem",
                "com.shineon.coder.service.convert.util.QueryItemCommonUtil",
                "com.shineon.coder.service.convert.CommonItem", "com.shineon.coder.db.common.ApiResultItem",
                FeignConstant.FEIGN_PACKAGE+String.format(".%sFeign",this.name));

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("QueryItemCommonUtil queryItemCommonUtil;"));

        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%sFeign feign;",this.name));


        dtoClassBuild.addTabContent("\r\n");
        dtoClassBuild.addTabContent("@Autowired");
        dtoClassBuild.addTabContent(String.format("%s commonUtil;",this.toolClass.getSimpleName()));

        for(String method: methods)
        {
            dtoClassBuild.addTabContent("\r\n");
            dtoClassBuild.addTabContent(String.format("public ApiResultItem %s(CommonItem item) throws Exception{",method.toLowerCase()));
            dtoClassBuild.addTabRightContent(String.format("QueryItem query = queryItemCommonUtil.toPojo(item);"));

            dtoClassBuild.addTabContent(String.format("CommonItem result =  feign.%s(item);",method.toLowerCase()));
            if(method.indexOf("list")>=0) {
                dtoClassBuild.addTabContent(String.format("return  new ApiResultItem(result ,commonUtil.toPojoList(result));"));
            }
            else {
                dtoClassBuild.addTabContent(String.format("return new ApiResultItem(result ,commonUtil.toPojo(result));"));
            }
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
