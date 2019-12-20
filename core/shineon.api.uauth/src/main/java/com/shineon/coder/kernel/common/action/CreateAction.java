package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateAction extends ICreateBase {

    public CreateAction(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil actionClassBuild = new ClassBuildUtil();
        String dtoName = this.name +"DTO";

        actionClassBuild.classInit(this.getClassName(),null
                ,null, ActionConstant.ACTION_PACKAGE,new String[]{"RestController","Slf4j"},
                true,this.toolClass.getName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController","org.springframework.web.bind.annotation.RequestMapping",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName, ActionConstant.ACTION_CONSTANT_PACKAGE+"." +this.getConstantName()
                ,"org.springframework.web.bind.annotation.RequestBody","com.alibaba.fastjson.JSONObject",
                "com.shineon.coder.db.common.ApiResultItem");


        actionClassBuild.addTabContent("\r\n");
        actionClassBuild.addTabContent("@Autowired");
        actionClassBuild.addTabContent(String.format("%s dto;",dtoName));

        actionClassBuild.addTabContent("\r\n");
        actionClassBuild.addTabContent("@Autowired");
        actionClassBuild.addTabContent(String.format("%s commonUtil;",this.toolClass.getSimpleName()));



        for(String method: methods)
        {
            actionClassBuild.addTabContent("\r\n");
            actionClassBuild.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)",this.getConstantName(),method.toUpperCase()));
            actionClassBuild.addTabContent(String.format("public ApiResultItem %s(@RequestBody JSONObject params) throws Exception{",method.toLowerCase()));
            actionClassBuild.addTabRightContent(String.format("return dto.%s(item);",method.toLowerCase()));
            actionClassBuild.addTabLeftContent(String.format("}"));
        }
        actionClassBuild.finish(this.classFile);
    }

    @Override
    protected void createConstant() throws IOException {
        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(this.getConstantName(),null,null, this.constantPackageName,null,true,null);

        for(String method: methods)
        {
            constantClassBuild.addTabContent("\r\n");
            constantClassBuild.addTabContent(String.format("public static final String ACTION_%s =\"/%s/%s\";",
                    method.toUpperCase(),this.name.toLowerCase(),method.toLowerCase()));
        }

        constantClassBuild.finish(this.constantFile);
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
        return ActionConstant.ACTION_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return true;
    }

    @Override
    protected String getConstantPackageName() {
        return ActionConstant.ACTION_CONSTANT_PACKAGE;
    }

    @Override
    protected String getClassName() {
        return this.name+"Controller";
    }

    @Override
    protected String getConstantName() {
        return this.name +"ControllerConstant";
    }
}
