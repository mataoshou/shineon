package com.shineon.coder.common.message;

import com.shineon.coder.common.cache.RedisLock;
import com.shineon.coder.common.cache.RedisUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;


@Component
public class MessageClient implements Runnable {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    List messageList = new LinkedList<MessageItem>();

    public void InitTask()
    {

    }


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

    public void addMessage(MessageItem item)
    {
        messageList.add(item);
    }

    public void addCache(MessageItem item, RedisLock redisLock)
    {

    }
}
