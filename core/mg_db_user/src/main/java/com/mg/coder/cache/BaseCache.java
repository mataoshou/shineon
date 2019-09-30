package com.mg.coder.cache;

import com.mg.coder.common.cache.RedisLock;
import com.mg.coder.common.cache.RedisUtil;
import com.mg.coder.common.util.SpringUtil;


public interface BaseCache {


    default boolean getLock(String lockName, RedisLock redisLock)
    {
        RedisUtil util = SpringUtil.getBean(RedisUtil.class);
        return util.lock(lockName,redisLock);
    }

    default String getCache(String key)
    {
        RedisUtil util = SpringUtil.getBean(RedisUtil.class);
        return util.get(key);
    }


    default void save(String key,String conent)
    {
        RedisUtil util = SpringUtil.getBean(RedisUtil.class);
        util.set(key,conent);
    }


}
