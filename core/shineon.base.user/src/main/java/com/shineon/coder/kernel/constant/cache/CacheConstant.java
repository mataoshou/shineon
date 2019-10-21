package com.shineon.coder.kernel.constant.cache;

public class CacheConstant {

    public static final String REDIS_KEY_PRE = "SHINEON.BASE.USER.";

    public static final String REDIS_KEY_LAST = ".DATA";



    /**
     * 用户数据缓存状态
     */
    public static String CACHE_SYS_USER ="CACHE_SYS_USER";
    public static int CACHE_SYS_USER_WAIT = 0;
    public static int CACHE_SYS_USER_SUCCESS = 100;



    /**
     *  默认缓存数据处理最小间隔
     */
    public static long CACHE_SYS_INTERVAL = 1000*60;

}
