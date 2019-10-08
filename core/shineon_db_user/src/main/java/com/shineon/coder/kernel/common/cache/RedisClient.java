package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.constant.RedisConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisClient implements Runnable {

    @Autowired
    public RedisUtil redisUtil;
    @Autowired
    RedisTemplate redisTemplate;


    Logger logger = LoggerFactory.getLogger(RedisClient.class);

    long lastTime = 0;

    List<String> keys = new ArrayList<>();

    @Override
    public void run() {


        for(String key:keys)
        {
            redisUtil.expire(key, RedisConstant.LOCK_HOLD_TIME);
        }


    }

    //添加锁维护状态
    public void addKeep(String key)
    {

    }
    //移除锁状态
    public void removeKey(String key)
    {

    }

    //查询是持有锁
    public boolean isKeep(String key)
    {
        return true;

    }

}
