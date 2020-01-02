package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.kernel.util.StringUtil;

import java.io.IOException;
import java.lang.reflect.Field;

public class CreateAction extends ICreate {

    public CreateAction(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }
    String dtoName = this.getName() +"DTO";
    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil actionClassBuild = new ClassBuildUtil();

        actionClassBuild.classInit(this.getClassName(),null
                ,null, ActionConstant.ACTION_PACKAGE,new String[]{"RestController","Slf4j"},
                true,this.getItem().getToolClassFullName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController","org.springframework.web.bind.annotation.RequestMapping",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName, ActionConstant.ACTION_CONSTANT_PACKAGE+"." +this.getConstantClassName()
                ,"org.springframework.web.bind.annotation.RequestBody","com.alibaba.fastjson.JSONObject",
                "com.shineon.coder.db.common.ApiResultItem",this.getItem().getPojoClassFullName());

        return actionClassBuild;

    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("%s dto;",dtoName));

        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent("@Autowired");
        classBuildUtil.addTabContent(String.format("%s commonUtil;",this.getItem().getToolClassName()));
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        classBuildUtil.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)",this.getConstantClassName(),methodName.toUpperCase()));
        classBuildUtil.addTabContent(String.format("public ApiResultItem %s(@RequestBody JSONObject params) throws Exception{",methodName.toLowerCase()));

        if(methodName.indexOf("get")>=0)
        {
            classBuildUtil.addTabRightContent(String.format("%s pojo = new %s();",this.getItem().getPojoClassName(),this.getItem().getPojoClassName()));
            classBuildUtil.addTabContent(String.format("pojo.setId(params.getString(\"id\"));"));
            classBuildUtil.addTabContent(String.format("return dto.%s(commonUtil.toCommon(pojo));",methodName));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("edit")>=0)
        {
            classBuildUtil.addTabRightContent(String.format("%s pojo = new %s();",this.getItem().getPojoClassName(),this.getItem().getPojoClassName()));
            Field[] fields = this.getItem().getPojoClass().getDeclaredFields();
            StringUtil stringUtil = new StringUtil();
            for(Field field: fields)
            {
                classBuildUtil.addTabContent(String.format("pojo.set%s(params.get%s(\"%s\"));",stringUtil.firstUpper(field.getName()),field.getType().getSimpleName(),field.getName()));
            }

            classBuildUtil.addTabContent(String.format("return dto.%s(commonUtil.toCommon(pojo));",methodName));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("list")>=0)
        {
            classBuildUtil.addTabRightContent(String.format("return dto.list(commonUtil.success());"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else if(methodName.indexOf("delete")>=0)
        {

            classBuildUtil.addTabRightContent(String.format("%s pojo = new %s();",this.getItem().getPojoClassName(),this.getItem().getPojoClassName()));
            classBuildUtil.addTabContent(String.format("pojo.setId(params.getString(\"id\"));"));
            classBuildUtil.addTabContent(String.format("return dto.delete(commonUtil.toCommon(pojo));"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else {
            classBuildUtil.addTabRightContent(String.format("return dto.%s(item);", methodName.toLowerCase()));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
    }

    @Override
    protected void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected ClassBuildUtil createConstantClass() throws IOException {
        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(this.getConstantClassName(),null,null, this.getConstantPackageName(),null,true,null);

        return constantClassBuild;
    }

    @Override
    protected void createConstantPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createConstantMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        classBuildUtil.addTabContent("\r\n");
        classBuildUtil.addTabContent(String.format("public static final String ACTION_%s =\"/%s/%s\";",
                methodName.toUpperCase(),this.getName(),methodName.toLowerCase()));
    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return ActionConstant.ACTION_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return true;
    }


    @Override
    protected String getConstantPackageName() {
        return ActionConstant.ACTION_CONSTANT_PACKAGE;
    }

    @Override
    protected String getClassNameLast() {
        return "Controller";
    }

    @Override
    protected String getConstantClassNameLast() {
        return "ControllerConstant";
    }

}
