package com.shineon.coder.common.message.base;

import com.shineon.coder.common.cache.RedisLock;
import com.shineon.coder.common.cache.RedisUtil;
import com.shineon.coder.constant.RedisConstant;
import com.shineon.coder.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class MessageClient implements Runnable {


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    MessageUtil messageUtil;

    List messageList = new LinkedList<MessageItem>();

    public void InitTask()
    {

    }


    @Override
    public void run()
    {
        String key = messageUtil.getLockName("");
        RedisLock redisLock = redisUtil.buildLock(key, RedisConstant.CACHE_KEY_LOCK_SYC);
        if(redisUtil.lock(key, redisLock))
        {
            String pattern = messageUtil.likeCode();

            List<String> srtMessage = redisUtil.likeValue(pattern);
        }
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
