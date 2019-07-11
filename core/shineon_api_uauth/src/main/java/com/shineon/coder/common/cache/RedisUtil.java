package com.shineon.coder.common.cache;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.common.constant.RedisConstant;
import com.shineon.coder.common.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * redis缓存辅助工具类
 */
@Component
public class RedisUtil implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RedisTemplate redisTemplate;


    Logger logger = LoggerFactory.getLogger(RedisUtil.class);


    @Bean
    public RedisLock emptyLock()
    {
        RedisLock lock = new RedisLock();

        return lock;
    }

    /**
     * 加锁
     * @param key
     * @param redisLock
     * @return
     */
    public boolean lock(String key,RedisLock redisLock)
    {

        logger.debug("[尝试获取redis锁]"+ key);

        Boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key,lockToJSON(redisLock).toJSONString(), RedisConstant.LOCK_HOLD_TIME, TimeUnit.MILLISECONDS);

//        System.out.println(isSuccess);

        if(isSuccess=null)return false;

        return isSuccess;
    }

    /**
     * 进行已知次数  连续获取锁
     */
    public boolean tryLock(int count,long interval,String key,RedisLock redisLock)
    {
        int no =0;

        while(no<count)
        {
            if(lock(key,redisLock))return true;

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     *  解锁
     */
    public void unlock(String key)
    {
        RedisClient redisClient = SpringUtil.getBean(RedisClient.class);

        redisTemplate.delete(key);

        redisClient.removeKey(key);
    }

    /**
     * 设置缓存数据 没有过期时间
     * @param key
     * @param value
     */
    public void set(Object key,Object value)
    {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 设置缓存数据  有过期时间
     * @param key
     * @param value
     * @param interval
     */
    public void set(Object key,Object value,Long interval)
    {
        redisTemplate.opsForValue().set(key,value,interval,TimeUnit.MILLISECONDS);
    }

    /**
     * 删除缓存数据
     * @param key
     * @return
     */
    public boolean remove(Object key)
    {
        return redisTemplate.delete(key);

    }

    /**
     * 延长存活时间
     * @param key
     * @param keep
     * @return
     */
    public boolean expire(String key,long keep)
    {
        return redisTemplate.expire(key,keep,TimeUnit.MILLISECONDS);
    }

    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    public String get(String key)
    {
        System.out.println(key);
        Object tmp = redisTemplate.opsForValue().get(key);
        System.out.println(".............111....."+tmp);
        return tmp.toString();
    }

    /**
     * 获取符合条件的所有缓存key
     * @param pattern
     */
    public void like(String pattern)
    {
        redisTemplate.keys(pattern);
    }

    public String buildKey()
    {

        return "";
    }


    public JSONObject lockToJSON(RedisLock lock)
    {
        JSONObject json = (JSONObject) JSONObject.toJSON(lock);

        return  json;
    }

    public  RedisLock jsonToLock(JSONObject json)
    {
        RedisLock lock = new RedisLock();
        lock.setKey(json.getString("lock"));
        lock.setLockType(json.getString("lockType"));
        return lock;
    }

    public RedisLock jsonToLock(String str)
    {
        JSONObject json=JSONObject.parseObject(str);
        return jsonToLock(json);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }
}
