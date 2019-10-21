package com.shineon.coder.kernel.constant.cache;

public class UserCacheConstant {

    public static final String SINGLE_CACHE_PRE = CacheConstant.REDIS_KEY_PRE+"USER";

    public static final String SINGLE_CACHE_LAST = "" + CacheConstant.REDIS_KEY_LAST;

    public static final String LIST_CACHE_PRE = CacheConstant.REDIS_KEY_PRE+"LIST.USER";

    public static final String LIST_CACHE_LAST = ""+ CacheConstant.REDIS_KEY_LAST;
}
