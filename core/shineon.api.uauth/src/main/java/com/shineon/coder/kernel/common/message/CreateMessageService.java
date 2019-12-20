package com.shineon.coder.kernel.common.message;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateMessageService  extends ICreateBase {

    public CreateMessageService(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {

        String clientName = this.name +"Client";
        ClassBuildUtil buildUtil = new ClassBuildUtil();
        String[] annotation =new String[]{"Component",String.format("EnableBinding(%s.class)",clientName)};

        buildUtil.classInit(this.getClassName(),"",null,packageName,annotation,true,
                "org.slf4j.Logger","org.slf4j.LoggerFactory",
                "org.springframework.cloud.stream.annotation.EnableBinding","org.springframework.cloud.stream.annotation.StreamListener",
                "org.springframework.stereotype.Component", MessageConstant.MESSAGE_PACKAGE+".client."+clientName);


        buildUtil.addTabContent(String.format("Logger logger = LoggerFactory.getLogger(%s.class);",this.getClassName()));

        buildUtil.addTabContent(String.format("@StreamListener(%s.INPUTNAME)",clientName));
        buildUtil.addTabContent("public void receive(String message)");
        buildUtil.addTabContent( "{");
        buildUtil.addTabRightContent("logger.info(\"收到消息，请处理：\"+message);");
        buildUtil.addTabLeftContent("}");


        buildUtil.finish(this.classFile);
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
        return MessageConstant.MESSAGE_SERVICE_PACKAGE;
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
        return this.name+"Service";
    }

    @Override
    protected String getConstantName() {
        return null;
    }
}
