package com.shineon.coder.common.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class MessageClient implements Runnable {


    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void run()
    {

    }

    //发送消息
    public void sendMessage()
    {

    }

    //构建消息
    public void buildMessage()
    {

    }
}
