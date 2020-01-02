package com.shineon.coder.kernel.common.message;

import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateMessageService  extends ICreate {

    public CreateMessageService(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {

        String clientName = this.getName() +"Client";
        ClassBuildUtil buildUtil = new ClassBuildUtil();
        String[] annotation =new String[]{"Component",String.format("EnableBinding(%s.class)",clientName)};

        buildUtil.classInit(this.getClassName(),"",null,this.getPackageName(),annotation,true,
                "org.slf4j.Logger","org.slf4j.LoggerFactory",
                "org.springframework.cloud.stream.annotation.EnableBinding","org.springframework.cloud.stream.annotation.StreamListener",
                "org.springframework.stereotype.Component",MessageConstant.MESSAGE_PACKAGE+".client."+clientName);

        return buildUtil;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        String clientName = this.getName() +"Client";

        classBuildUtil.addTabContent(String.format("Logger logger = LoggerFactory.getLogger(%s.class);",this.getClassName()));

        classBuildUtil.addTabContent(String.format("@StreamListener(%s.INPUTNAME)",clientName));
        classBuildUtil.addTabContent("public void receive(String message)");
        classBuildUtil.addTabContent( "{");
        classBuildUtil.addTabRightContent("logger.info(\"收到消息，请处理：\"+message);");
        classBuildUtil.addTabLeftContent("}");
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {

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
        return MessageConstant.MESSAGE_SERVICE_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return null;
    }

    @Override
    protected String getClassNameLast() {
        return "Service";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
