//package com.shineon.coder.kernel.common.message.base;
//
//import com.alibaba.fastjson.JSONObject;
//import com.shineon.coder.kernel.util.GuidUtil;
//import com.shineon.coder.kernel.util.SpringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
///**
// * 消息队列的辅助工具类
// */
//@Component
//public class MessageUtil {
//
//
//    @Autowired
//    private Environment env;
//
//
//    /**
//     * 初始化消息对象
//     *
//     */
//    public MessageItem empty()
//    {
//        MessageItem item = SpringUtil.getBean(MessageItem.class);
//
//        item.setCode(getCode());
//
//        return item;
//    }
//
//    /**
//     * 生成消息编码
//     */
//    public  String getCode()
//    {
//        String sys = env.getProperty("spring.application.name");
//
//        GuidUtil guidUtil = SpringUtil.getBean(GuidUtil.class);
//
//        String code = String.format("%s_MESSAGE_ITEM_%s",sys, guidUtil.gen());
//        return  code;
//    }
//
//
//    public String getLockName(String message)
//    {
//        return String.format("%s_MESSAGE_LOCK",message);
//    }
//
//    /**
//     * 缓存中  模糊查询的key
//     */
//    public  String likeCode()
//    {
//        String sys = env.getProperty("spring.application.name");
//
//        String code = String.format("%s_MESSAGE_ITEM_*",sys);
//
//        return code;
//    }
//
//
//    public  JSONObject toJSON(MessageItem item)
//    {
//        JSONObject json = (JSONObject) JSONObject.toJSON(item);
//
//        System.out.println(json.toJSONString());
//
//        return  json;
//    }
//
//    public MessageItem toMessage(JSONObject json)
//    {
//        MessageItem item = new MessageItem();
//
//        item.setCode(json.getString("code"));
//        return item;
//    }
//
//    public static void main(String[] args)
//    {
//        MessageItem item = new MessageItem();
//        item.setId(1);
//        MessageUtil util = new MessageUtil();
//        util.toJSON(item);
//
//    }
//
//    public MessageUtil()
//    {
//        System.out.println("......................初始化,,,,,util");
//    }
//
//
//}
