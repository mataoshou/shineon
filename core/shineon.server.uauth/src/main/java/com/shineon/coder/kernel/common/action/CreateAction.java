package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateAction extends ICreate {

    public CreateAction(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    String dtoName = this.getName() +"DTO";

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil actionClassBuild = new ClassBuildUtil();

        actionClassBuild.classInit(this.getClassName(),null
                ,null, this.getPackageName(),new String[]{"RestController","Slf4j"},
                true,this.getItem().getToolClassFullName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController","org.springframework.web.bind.annotation.RequestMapping",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName, this.getConstantClassFullName()
                ,"org.springframework.web.bind.annotation.RequestBody");

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
        if(methodName.indexOf("delete")>=0)
        {
            classBuildUtil.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)",this.getConstantClassName(),methodName.toUpperCase()));
            classBuildUtil.addTabContent(String.format("public CommonItem %s(@RequestBody CommonItem item) throws Exception{",methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("dto.delete(item);"));
            classBuildUtil.addTabContent(String.format("return commonUtil.success();"));
            classBuildUtil.addTabLeftContent(String.format("}"));
        }
        else {
            classBuildUtil.addTabContent(String.format("@RequestMapping(%s.ACTION_%s)", this.getConstantClassName(), methodName.toUpperCase()));
            classBuildUtil.addTabContent(String.format("public CommonItem %s(@RequestBody CommonItem item)throws Exception{", methodName.toLowerCase()));
            classBuildUtil.addTabRightContent(String.format("return commonUtil.toCommon(dto.%s(item));", methodName.toLowerCase()));
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
