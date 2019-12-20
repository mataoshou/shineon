package com.shineon.coder.kernel.constant.message;

/**
 * 用来存放消息相关的产量
 */
public class MessageConstant {


    static public final Integer MESSAGE_RETRY_COUNT = 5;//重发次数

   static public final Long MESSAGE_RETYR_INTERVAL =1000*60L;//一分钟

    //回复
    static public final  Integer MESSAGE_TYPE_REPLY = 1;
    //不回复
    static public final Integer MESSAGE_TYPE_UNREPLY = 2;

    static public final String MESSAGE_TYPE_SINGLE = "SINGLE";
    static public final String MESSAGE_TYPE_PUBLISH = "PUBLISH";

    //操作类型
    static public final  String MESSAGE_OPER_EDIT = "EDIT";
    static public final  String MESSAGE_OPER_INSERT = "INSERT";
    static public final  String MESSAGE_OPER_DELETE = "DELETE";
    static public final  String MESSAGE_OPER_RSELECT = "SELECT";

    static public final  String MESSAGE_PACKAGE = "com.shineon.coder.service.mq";
    static public final  String MESSAGE_CLINET_PACKAGE = "com.shineon.coder.service.mq.client";
    static public final  String MESSAGE_SERVICE_PACKAGE = "com.shineon.coder.service.mq.service";

}
