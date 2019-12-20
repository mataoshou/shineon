package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateFeign extends ICreateBase {
    public CreateFeign(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        ClassBuildUtil feignClassBuild = new ClassBuildUtil();

        String fallbackName =this.name +"FeignFallBack";

        feignClassBuild.classInit(this.getClassName(),null,null, this.packageName
                ,new String[]{String.format("FeignClient(name = %s.FEIGN_SERVER_NAME,fallback = %s.class)",this.getConstantName(),fallbackName),},
                false,"lombok.extern.slf4j.Slf4j",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem","org.springframework.cloud.openfeign.FeignClient",
                "org.springframework.web.bind.annotation.RequestMapping",
                this.constantPackageName +"." +this.getConstantName());

        for(String method: methods)
        {
            feignClassBuild.addTabContent("\r\n");
            feignClassBuild.addTabContent(String.format("@RequestMapping(%s. FEIGN_%s)",this.getConstantName(),method.toUpperCase()));
            feignClassBuild.addTabContent(String.format("CommonItem %s(CommonItem item);",method.toLowerCase()));
        }
        feignClassBuild.finish(this.classFile);
    }

    @Override
    protected void createConstant() throws IOException {
        ClassBuildUtil constantClassBuild = new ClassBuildUtil();

        constantClassBuild.classInit(this.getConstantName(),null,null, FeignConstant.FEIGN_CONSTANT_PACKAGE,null,true,null);

        constantClassBuild.addTabContent("\r\n");
        constantClassBuild.addTabContent(String.format("public static final String FEIGN_SERVER_NAME =\"%s\";",this.sysName));
        for(String method: methods)
        {
            constantClassBuild.addTabContent("\r\n");
            constantClassBuild.addTabContent(String.format("public static final String FEIGN_%s =\"/%s/%s\";",
                    method.toUpperCase(),this.name.toLowerCase(),method.toLowerCase()));
        }

        constantClassBuild.finish(constantFile);
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
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return true;
    }

    @Override
    protected String getConstantPackageName() {
        return FeignConstant.FEIGN_CONSTANT_PACKAGE;
    }

    @Override
    protected String getClassName() {
        return this.name+"Feign";
    }

    @Override
    protected String getConstantName() {
        return this.name+"FeignConstant";
    }
}
