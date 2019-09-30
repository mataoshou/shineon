package com.shineon.coder.cache;

import com.shineon.coder.common.cache.RedisLock;
import com.shineon.coder.common.cache.RedisUtil;
import com.shineon.coder.common.util.SpringUtil;


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
