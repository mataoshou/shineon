package com.shineon.coder.kernel.common.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.kernel.constant.RedisConstant;
import com.shineon.coder.kernel.util.Md5Util;
import com.shineon.coder.kernel.util.SpringUtil;
import com.shineon.coder.service.convert.CommonItem;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存辅助工具类
 */
@Component
public class CacheUtil
//        implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired
    private RedisTemplate redisTemplate;


    Logger logger = LoggerFactory.getLogger(CacheUtil.class);


    /**
     * 创建 缓存key
     * @param prev
     * @param last
     * @param item
     * @return
     * @throws Exception
     */
    public String createCacheKey(String prev, String last, CommonItem item) throws Exception {
        String cacheKey = prev + "." + Md5Util.digest(item.toJsonString())+"." +last;

        return cacheKey;
    }


//    @Bean
//    public RedisLock emptyLock()
//    {
//        RedisLock lock = new RedisLock();
//
//        lock.setLockState((short) 0);
//        lock.setKeepInterval(RedisConstant.LOCK_KEEP_INTERVAL);
//        lock.setOverTime(RedisConstant.LOCK_HOLD_TIME);
//        lock.setLockCount(0);
//
//        return lock;
//    }


//    public RedisLock buildLock(String key,String lockType)
//    {
//        RedisLock lock = emptyLock();
//        lock.setKey(key);
//        lock.setLockType(lockType);
//
//        return  lock;
//    }

    /**
     * 加锁
     * @param key
     * @param redisLock
     * @return
     */
//    public boolean lock(String key,RedisLock redisLock)
//    {
//
//        logger.debug("[尝试获取redis锁]"+ key);
//
//        Boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key,lockToJSON(redisLock).toJSONString(), RedisConstant.LOCK_HOLD_TIME, TimeUnit.MILLISECONDS);
//
////        System.out.println(isSuccess);
//
//        if(isSuccess=null)return false;
//
//        return isSuccess;
//    }

//    /**
//     * 进行已知次数  连续获取锁
//     */
//    public boolean tryLock(int count,long interval,String key,RedisLock redisLock)
//    {
//        int no =0;
//
//        while(no<count)
//        {
//            if(lock(key,redisLock))return true;
//
//            try {
//                Thread.sleep(interval);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return false;
//    }

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
    public void set(String key,CommonItem item)
    {
        redisTemplate.opsForValue().set(key,item.toJsonString());
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
    public CommonItem get(String key)
    {
        System.out.println(key);
        String tmp = redisTemplate.opsForValue().get(key).toString();
        CommonItem item = JSON.parseObject(tmp,CommonItem.class);

        return item;
    }

    /**
     * 获取符合条件的所有缓存key
     * @param pattern
     */
    public List<String> likeKey(String pattern)
    {
        Set<String> set = redisTemplate.keys(pattern);

        List keys = new ArrayList<>(set);

        return keys;
    }


    public List<String> likeValue(String pattern)
    {
        List<String> values = new ArrayList<>();

        List<String> keys = likeKey(pattern);

        values = redisTemplate.opsForValue().multiGet(keys);

        return values;
    }






//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//    }
}
