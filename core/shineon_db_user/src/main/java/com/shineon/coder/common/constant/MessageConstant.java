package com.shineon.coder.common.constant;

/**
 * 用来存放消息相关的产量
 */
public class MessageConstant {


   static public final Long MESSAGE_RETYR_INTERVAL =1000*60L;//一分钟

    //回复
    static public final  Integer MESSAGE_TYPE_REPLY = 1;
    //不回复
    static public final Integer MESSAGE_TYPE_UNREPLY = 2;

    //操作类型
    static public final  String MESSAGE_OPER_UPDATE = "UPDATE";
    static public final  String MESSAGE_OPER_INSERT = "INSERT";
    static public final  String MESSAGE_OPER_DELETE = "DELETE";
    static public final  String MESSAGE_OPER_REFRESH = "REFRESH";

}
