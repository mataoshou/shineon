package com.shineon.coder.kernel.common.message.base;//package com.shineon.coder.kernel.common.message.base;
//
//import com.shineon.coder.kernel.common.cache.RedisLock;
//import com.shineon.coder.kernel.common.cache.RedisUtil;
//import com.shineon.coder.kernel.constant.RedisConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.LinkedList;
//import java.util.List;
//
//
//@Component
//public class MessageClient implements Runnable {
//
//
//    @Autowired
//    RedisUtil redisUtil;
//
//    @Autowired
//    MessageUtil messageUtil;
//
//
//    public void InitTask()
//    {
//
//    }
//
//
//    @Override
//    public void run()
//    {
//        String key = messageUtil.getLockName("");
//        RedisLock redisLock = redisUtil.buildLock(key, RedisConstant.CACHE_KEY_LOCK_SYC);
//        if(redisUtil.lock(key, redisLock))
//        {
//            String pattern = messageUtil.likeCode();
//
//            List<String> srtMessage = redisUtil.likeValue(pattern);
//        }
//    }
//
//    //发送消息
//    public void sendMessage()
//    {
//
//    }
//
//    //构建消息
//    public void buildMessage()
//    {
//
//    }
//
//}