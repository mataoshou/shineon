package com.shineon.coder.service.mq.oper;

import com.alibaba.fastjson.JSON;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.kernel.constant.pool.PoolConstant;
import com.shineon.coder.service.mq.BaseMessage;
import com.shineon.coder.service.mq.MessageItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class OperationUtil {

    List<IBaseMessageOperation> list = new ArrayList();

    Set<IBaseMessageOperation> set = new HashSet();



    @Autowired
    MQMessageCommonUtils mqMessageCommonUtils;
    /**
     * 添加操作对象
     * @param operation
     */
    protected void addOperation(IBaseMessageOperation operation)
    {
        synchronized(this) {
            int length = set.size();
            set.add(operation);

            //防止出现多个spring容器重复添加
            if(set.size()!=length) {
                list.add(operation);
                log.info("添加消息操作对象" + operation.getClass().getName() );
            }
        }
    }

    /**
     * 处理消息
     * @param message
     * @throws Exception
     */
    public void excute(String message) throws Exception {
       MessageItem item =  JSON.parseObject(message,MessageItem.class);
       if(item==null)
       {
           throw new Exception("非法的消息内容："+message);
       }
       excute(item);
    }

    /**
     * 处理消息
     * @param item
     * @throws Exception
     */
    public void excute(MessageItem item) throws Exception {

        IBaseMessageOperation messageOperation = null;

        ///获取执行的Operation对象
        for(IBaseMessageOperation operation : list)
        {
            if(operation.check(item))
            {
                messageOperation = operation;
                break;
            }
        }

        ///处理消息
        if(messageOperation!=null)
        {
            try {
                if(item.getMstype().equals(MessageConstant.MESSAGE_TYPE_SINGLE))
                {
                    mqMessageCommonUtils.getMessage(item);
                }

                messageOperation.oper(item);

                if(item.getMstype().equals(MessageConstant.MESSAGE_TYPE_SINGLE))
                {
                    mqMessageCommonUtils.success(item);
                }

            }
            catch (Exception e)
            {
                if(item.getMstype().equals(MessageConstant.MESSAGE_TYPE_SINGLE))
                {
                    mqMessageCommonUtils.fail(item);
                }

                log.info(item.getId() + "消息消费失败" + e.getMessage());

                throw e;
            }
        }
        else{
            throw new Exception("没有对应的消息类型："+item.getOperType());
        }
    }


    Lock lock = new ReentrantLock();
    /**
     * 发送消息  放入线程池发送 不会有实时反馈
     * @param sender
     * @param item
     * @return
     * @throws Exception
     */
    @Async(PoolConstant.POOL_SCHEDULE)
    public void sendMessage(BaseMessage sender,MessageItem item) throws Exception {
        Thread.sleep(5000);
        log.info("继续发送消息");
        int count =0;
        try {
            lock.lock();
            if (!mqMessageCommonUtils.isRepeatSend(item)) {

                log.info("重复的消息，不发送：" + mqMessageCommonUtils.buildId(item));
//                return false;
                return;
            }

            while (true) {
                boolean isSendSuccess = sender.output().send(MessageBuilder.withPayload(item.toJsonString()).build());
                if (isSendSuccess) {
                    mqMessageCommonUtils.sendSuccess(item);
                    log.info("成功发送消息：" + item.toJsonString());
//                    return true;
                    return;
                }

                count++;
                if (count >= 3) {
                    log.info("消息尝试发送三次都失败，请检查 : " + item.toJsonString());
//                    return false;
                    return;
                }
            }
        }
        finally {
            lock.unlock();
        }

    }


}
