package com.shineon.coder.common.cache;

import com.shineon.coder.common.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis缓存辅助工具类
 */
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    @Bean
    public RedisLock emptyLock()
    {
        RedisLock lock = new RedisLock();

        return lock;
    }


    public void lock(String key)
    {

    }

    public void tryLock(int count,long interval,int type,String key)
    {

    }

    public void unlock(String key)
    {


    }


    public void lockUpdate()
    {


    }

    public void lockRemove()
    {


    }

    public void add()
    {

    }

    public void update()
    {

    }

    public void remove()
    {


    }

    public void get()
    {

    }

    public void like()
    {

    }

    public String buildKey()
    {

        return "";
    }
}
