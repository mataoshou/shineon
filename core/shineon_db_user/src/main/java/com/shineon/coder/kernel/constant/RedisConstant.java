package com.shineon.coder.kernel.constant;


/**
 * 用来存放redis缓存相关的常量
 */
public class RedisConstant {


    public static  final String CACHE_KEY_LOCK_READ = "READ";
    public static  final String CACHE_KEY_LOCK_WRITE = "WRITE";
    public static  final String CACHE_KEY_LOCK_SYC = "SYC";


    public static final Long LOCK_KEEP_INTERVAL = 3*1000L;

    public static final  Long LOCK_HOLD_TIME = 10*1000L;


    public static  final  Integer LOCK_HOLD_STATE = 100;

}
