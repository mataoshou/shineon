package com.shineon.coder.service.mq.oper;

import com.esotericsoftware.minlog.Log;
import com.shineon.coder.db.pojo.MqMessage;
import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.service.cache.MessageCache;
import com.shineon.coder.service.convert.util.QueryItemCommonUtil;
import com.shineon.coder.service.mq.MessageItem;
import com.shineon.coder.service.mq.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQMessageCommonUtils {
   @Autowired
   MessageUtil util;

   @Autowired
   MessageCache cache;

   @Autowired
   QueryItemCommonUtil queryItemCommonUtil;

   public MqMessage empty()
   {
      MqMessage mqMessage = new MqMessage();
      mqMessage.setMstatus((short) 0);
      mqMessage.setRetry(0);

      return mqMessage;
   }

   public MqMessage empty(MessageItem item) throws Exception {
      MqMessage mqMessage = new MqMessage();
      mqMessage.setSourceSys(item.getSourceName());
      mqMessage.setDstSys(item.getDstName());
      mqMessage.setId(item.getId());
      mqMessage.setMstatus((short) 0);
      mqMessage.setMessage(item.toJsonString());
      mqMessage.setRetry(0);
      mqMessage.setId(buildId(item));
      mqMessage.setLastModifyTime(System.currentTimeMillis());

      return mqMessage;
   }

   /**
    * 构建消息缓存对象
    * @param message
    * @return
    * @throws Exception
    */
   protected MqMessage initMessage(String message) throws Exception {
      MessageItem item = util.getMessage(message);

      MqMessage mqMessage = empty(item);

      return mqMessage;
   }


   /**
    * 构建消息缓存id
    * @param item
    * @return
    * @throws Exception
    */
   public String buildId(MessageItem item) throws Exception {
      String key = item.toCode();

      return key;
   }


   /**
    *检查是否发送消息  获取是否有消息的缓存
    * @param item
    * @return
    * @throws Exception
    */
   public boolean isRepeatSend(MessageItem item) throws Exception {
      String key = buildId(item);

      QueryItem queryItem = queryItemCommonUtil.createPojo(key);

      MqMessage mqMessage =  cache.get(queryItem);

      if(mqMessage!=null)
      {
         return false;
      }

      return true;
   }

   /**
    * 获取消息缓存对象
    * @param item
    * @return
    * @throws Exception
    */
   public MqMessage getMessage(MessageItem item) throws Exception {
      MqMessage mqMessage = getCache(item);


      if(mqMessage.getMstatus()==1&&(System.currentTimeMillis() - mqMessage.getLastModifyTime())>1000*60*10)
      {
         Log.info(mqMessage.getId() +"：消息已经处理超过10分钟，未结束，认为处理失效！");
         return null;
      }

      mqMessage.changeStatus((short) 1);

      cache.update(mqMessage);

      return mqMessage;
   }

   public MqMessage sendSuccess(MessageItem item) throws Exception {
      MqMessage mqMessage = empty(item);

      cache.setCache(mqMessage);

      return mqMessage;
   }

   /**
    * 消息消费成功
    * @param item
    * @return
    */
   public MqMessage success(MessageItem item) throws Exception {
      MqMessage mqMessage = getCache(item);

      mqMessage.changeStatus((short) 100);
      cache.update(mqMessage);

      return mqMessage;
   }

   /**
    * 消息消费成功
    * @param item
    * @return
    */
   public MqMessage fail(MessageItem item) throws Exception {
      MqMessage mqMessage = getCache(item);

      mqMessage.changeStatus((short) -1);
      cache.update(mqMessage);

      return mqMessage;
   }

   public MqMessage retry(MessageItem item) throws Exception {
      MqMessage mqMessage = getCache(item);

      mqMessage.retrySend();
      cache.update(mqMessage);

      return mqMessage;
   }

   public void delete(MessageItem item) throws Exception {
      MqMessage mqMessage = getCache(item);

      cache.delete(mqMessage);
   }

   public MqMessage getCache(MessageItem item) throws Exception {
      String key = buildId(item);
      MqMessage mqMessage = getCache(key);

      return mqMessage;
   }

   public MqMessage getCache(String key ) throws Exception {
      QueryItem queryItem = queryItemCommonUtil.createPojo(key);

      MqMessage mqMessage =  cache.get(queryItem);

      return mqMessage;
   }

}
