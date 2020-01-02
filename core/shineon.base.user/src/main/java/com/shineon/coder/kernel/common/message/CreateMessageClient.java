package com.shineon.coder.kernel.common.message;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.kernel.common.ibase.ICreate;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.kernel.util.FileStore;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class CreateMessageClient extends ICreate {

    public CreateMessageClient(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil buildUtil = new ClassBuildUtil();
        buildUtil.classInit(this.getClassName(),"BaseMessage",null
                ,this.getPackageName(),null,false,
                "org.springframework.cloud.stream.annotation.Input","org.springframework.cloud.stream.annotation.Output",
                "org.springframework.messaging.MessageChannel","org.springframework.messaging.SubscribableChannel","com.shineon.coder.service.mq.BaseMessage");

        return buildUtil;





    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {


        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format("String  INPUTNAME = \"%sMessageInput\";",this.getName()));
        classBuildUtil.addTabContent("@Input(INPUTNAME)");
        classBuildUtil.addTabContent( "@Override");
        classBuildUtil.addTabContent("SubscribableChannel input();");

//        buildUtil.addContent("\r");
        classBuildUtil.addTabContent("\r");

        classBuildUtil.addTabContent(String.format("String  OUTPUTNAME = \"%sMessageOutput\";",this.getName()));
        classBuildUtil.addTabContent("@Output(OUTPUTNAME)");
        classBuildUtil.addTabContent("@Override");
        classBuildUtil.addTabContent("MessageChannel output();");

        buildYML(this.getName());
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

    private void buildYML(String messageName) throws IOException {
        File application = new File(System.getProperty("user.dir"),"src\\main\\resources\\application.yml");

        System.out.println(application.getPath());

        String content = FileStore.getContent(application,"UTF-8");

        if(content.indexOf(String.format( "%sMessageInput",messageName))>0||content.indexOf(String.format( "%sMessageOutput",messageName))>0) {
            logger.info(String.format("application.yml  中包含相同名字的配置[%s]，请检查！！！",messageName));
            return;
        }

        Yaml yaml = new Yaml();

        Object obj =yaml.load(new FileInputStream(application));
        System.out.println(obj);
        //也可以将值转换为Map
        Map map =(Map)yaml.load(new FileInputStream(application));
        JSONObject json = (JSONObject) JSONObject.toJSON(map);

        buildJson(messageName,json);

        String jsonAsYaml = yaml.dump(json,false).replace("!com.alibaba.fastjson.JSONObject","").trim();

        while(true)
        {
            if(jsonAsYaml.startsWith("-"))
            {
                jsonAsYaml = jsonAsYaml.substring(1).trim();
                continue;
            }
            break;
        }

        System.out.println(jsonAsYaml);

        FileStore.putString(application,jsonAsYaml,"UTF-8");
    }

    private void buildJson(String messageName,JSONObject jsonObject)
    {
        String[] paths = new String[]{"spring","cloud","stream","bindings"};
        boolean isBegin = false;

        JSONObject json= jsonObject;
        for (int i=0;i<paths.length;i++)
        {
            String path = paths[i];
            if(isBegin)
            {
                JSONObject tmp = new JSONObject();
                json.put(path,tmp);
                json = tmp;
                continue;
            }

            if(json.containsKey(path))
            {
                json = json.getJSONObject(path);
            }
            else {
                isBegin = true;
                i--;
            }
        }

        JSONObject channel = new JSONObject();

        JSONObject input = new JSONObject();

        input.put("destination",String.format("%sMessage",messageName));
        json.put(String.format("%sMessageInput",messageName),input);

        JSONObject output = new JSONObject();

        output.put("destination",String.format("%sMessage",messageName));
        json.put(String.format("%sMessageOutput",messageName),output);


    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return MessageConstant.MESSAGE_CLINET_PACKAGE;
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
        return "Client";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }
}
