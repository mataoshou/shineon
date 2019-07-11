package com.shineon.coder.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisClient implements Runnable, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public RedisUtil redisUtil;
    @Autowired
    RedisTemplate redisTemplate;

//    {

//
//    }

    Logger logger = LoggerFactory.getLogger(RedisClient.class);

    long lastTime = 0;

    @Override
    public void run() {




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





    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("....................."+redisTemplate);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }
}
