package com.shineon.coder.service.mq;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.common.util.ClassBuildUtil;
import com.shineon.coder.common.util.FileStore;
import com.shineon.coder.common.util.StringUtil;
import org.ho.yaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.util.Map;

public class MessageBuild {

    Logger logger = LoggerFactory.getLogger(MessageBuild.class);

    public File buildFilePath(String... className) throws Exception {
        String sys = System.getProperty("user.dir");
        File coder = new File(sys, "src\\main\\java\\");

        String pags = this.getClass().getPackage().getName().replace(".", "\\");

        File root = new File(coder, pags);
        if(className.length>0) {
            String fileName = className[className.length-1] + ".java";

            for(int i=0;i<className.length-1;i++) {
                root = new File(root, className[i]);
            }
            File file =new File(root,fileName);


            return file;
        }
        throw  new Exception("路径不能为空");
    }


    public void buildBase() throws Exception {

        String className = "BaseMessage";
        File classFile = buildFilePath(className);

        if (classFile.exists()) {
            logger.info(classFile.getPath() + "文件已存在,不会重复生成");
            return;
        }

        String content = buildBaseContent();

        ClassBuildUtil buildUtil = new ClassBuildUtil();
        buildUtil.createFile(classFile, content);
    }


    public void buildMessage(String messageName) throws Exception {

        buildBase();

        StringUtil stringUtil = new StringUtil();

        ClassBuildUtil buildUtil = new ClassBuildUtil();

        messageName = stringUtil.firstUpper(messageName);

        String clientName = stringUtil.firstUpper(messageName +"MessageClient" );

        String serviceName = stringUtil.firstUpper(messageName +"MessageService");

        File clientFile = buildFilePath("client",clientName);

        String clinetConent = buildClentContent(clientName,messageName);

        buildUtil.createFile(clientFile, clinetConent);

        File serviceFile = buildFilePath("service",serviceName);

        String ServiceConent = buildServiceContent(serviceName,clientName);


        buildUtil.createFile(serviceFile, ServiceConent);


        buildYML(messageName);

    }

    public void buildYML(String messageName) throws IOException {
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

        String jsonAsYaml = yaml.dump(json,false).replace("!com.alibaba.fastjson.JSONObject","").replace("-","").trim();

        System.out.println(jsonAsYaml);



//        else {
//            if(!content.endsWith("\n"))
//            {
//                content +="\n";
//            }
//            String channel = String.format("       %sMessageInput:\n", messageName) +
//                    String.format("          destination: %sMessage\n", messageName) +
//                    String.format("       %sMessageOutput:\n", messageName) +
//                    String.format("          destination: %sMessage", messageName);
//            content +=  channel;
//        }

        FileStore.putString(application,jsonAsYaml,"UTF-8");
    }

    public void buildJson(String messageName,JSONObject jsonObject)
    {
        String[] paths = new String[]{"spring","cloud","stream","bindings"};
        boolean isBegin = false;

        JSONObject json= jsonObject;
        for (String path : paths)
        {
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

    public String buildClentContent(String clientName,String messageName) {

        ClassBuildUtil buildUtil = new ClassBuildUtil();
        String fileConent = buildUtil.classInit(clientName,"BaseMessage",this.getClass().getPackage().getName()+".client",null,false,
                "org.springframework.cloud.stream.annotation.Input","org.springframework.cloud.stream.annotation.Output",
                "org.springframework.messaging.MessageChannel","org.springframework.messaging.SubscribableChannel","com.shineon.coder.service.mq.BaseMessage");

        String conent ="";

        conent = buildUtil.addContent(conent, String.format("String  INPUTNAME = \"%sMessageInput\";",messageName));
        conent = buildUtil.addContent(conent, "@Input(INPUTNAME)");
        conent = buildUtil.addContent(conent, "@Override");
        conent = buildUtil.addContent(conent, "SubscribableChannel input();");


        conent = buildUtil.addContent(conent, String.format("String  OUTPUTNAME = \"%sMessageOutput\";",messageName));
        conent = buildUtil.addContent(conent, "@Output(OUTPUTNAME)");
        conent = buildUtil.addContent(conent, "@Override");
        conent = buildUtil.addContent(conent, "MessageChannel output();");


        fileConent = fileConent.replace("##1",conent);

        return fileConent;
    }

    public String buildServiceContent(String serviceName,String clientName)
    {
        ClassBuildUtil buildUtil = new ClassBuildUtil();
        String[] annotation =new String[]{"Component",String.format("EnableBinding(%s.class)",clientName)};

        String fileConent = buildUtil.classInit(serviceName,"",this.getClass().getPackage().getName()+".service",annotation,true,
                "org.slf4j.Logger","org.slf4j.LoggerFactory",
                "org.springframework.cloud.stream.annotation.EnableBinding","org.springframework.cloud.stream.annotation.StreamListener",
                "org.springframework.stereotype.Component",this.getClass().getPackage().getName()+".client."+clientName);

        String conent ="";

        conent = buildUtil.addContent(conent, String.format("Logger logger = LoggerFactory.getLogger(%s.class);",serviceName));

        conent = buildUtil.addContent(conent, String.format("@StreamListener(%s.INPUTNAME)",clientName));
        conent = buildUtil.addContent(conent, "public void receive(String message)");
        conent = buildUtil.addContent(conent, "{");
        conent = buildUtil.addTabConent(conent, "logger.info(\"收到消息，请处理：\"+message);");
        conent = buildUtil.subTabConent(conent, "}");



//        conent = buildUtil.addContent(conent, String.format("@StreamListener(%s.OUTPUTNAME)",clientName));
//        conent = buildUtil.addContent(conent, "public void callBack(String message)");
//        conent = buildUtil.addContent(conent, "{");
//        conent = buildUtil.addTabConent(conent, "logger.info(\"收到未处理的返回消息：\"+message);");
//        conent = buildUtil.subTabConent(conent, "}");


        fileConent = fileConent.replace("##1",conent);

        return fileConent;
    }



    public String buildBaseContent()
    {

        ClassBuildUtil buildUtil = new ClassBuildUtil();
        String fileConent = "";
        fileConent = buildUtil.classInit("BaseMessage","","com.shineon.coder.service.mq",null,false,
                "org.springframework.messaging.MessageChannel","org.springframework.messaging.SubscribableChannel");

        String conent ="";

        conent = buildUtil.addContent(conent," SubscribableChannel input();");

        conent = buildUtil.addContent(conent," MessageChannel output();");

        fileConent = fileConent.replace("##1",conent);

        return fileConent;
    }



    public static void main(String[] args) throws Exception {
        MessageBuild messageBuild = new MessageBuild();
        messageBuild.buildMessage("matao1");


    }



}
