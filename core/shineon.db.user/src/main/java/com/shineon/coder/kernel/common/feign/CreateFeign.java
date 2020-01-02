package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateFeign extends ICreate {
    public CreateFeign(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil feignClassBuild = new ClassBuildUtil();

        String fallbackName =this.getName() +"FeignFallBack";

        feignClassBuild.classInit(this.getClassName(),null,null, this.getPackageName()
                ,new String[]{String.format("FeignClient(name = %s.FEIGN_SERVER_NAME,fallback = %s.class)",this.getConstantClassName(),fallbackName),},
                false,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.cloud.openfeign.FeignClient",
                "org.springframework.web.bind.annotation.RequestMapping",
                this.getConstantClassFullName());

        return feignClassBuild;

    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        classBuildUtil.addTabContent(String.format("@RequestMapping(%s.FEIGN_%s)",this.getConstantClassName(),methodName.toUpperCase()));
        classBuildUtil.addTabContent(String.format("CommonItem %s(CommonItem item);",methodName.toLowerCase()));
    }

    @Override
    protected void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected ClassBuildUtil createConstantClass() throws IOException {
        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(this.getConstantClassName(),null,null, FeignConstant.FEIGN_CONSTANT_PACKAGE,null,true,null);


        return constantClassBuild;
    }

    @Override
    protected void createConstantPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        classBuildUtil.addTabContent(String.format("public static final String FEIGN_SERVER_NAME =\"%s\";",this.getItem().getSysName()));
    }

    @Override
    protected void createConstantMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {
        classBuildUtil.addTabContent(String.format("public static final String FEIGN_%s =\"/%s/%s\";",
                methodName.toUpperCase(),this.getName(),methodName.toLowerCase()));
    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return true;
    }

    @Override
    protected String getConstantPackageName() {
        return FeignConstant.FEIGN_CONSTANT_PACKAGE;
    }

    @Override
    protected String getClassNameLast() {
        return "Feign";
    }

    @Override
    protected String getConstantClassNameLast() {
        return "FeignConstant";
    }

}
