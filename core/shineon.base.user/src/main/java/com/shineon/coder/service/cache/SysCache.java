package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.CacheItem;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.util.TypeConvert;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.CacheItemCommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 系统状态缓存
 */
@Service
@Slf4j
public class SysCache {

    public static SysCache single = new SysCache();

    CacheItemCommonUtil commonUtil = new CacheItemCommonUtil();


    ConcurrentHashMap<String, CacheItem> mg_cache = new  ConcurrentHashMap<String, CacheItem>();


    public CacheItem getCache(String cacheKey)
    {
        CacheItem item = mg_cache.get(cacheKey);
        if(item ==null)
        {
            addCache(cacheKey);
            item = mg_cache.get(cacheKey);
        }

        return item;
    }


    public CommonItem getCommonItem(String cacheKey)
    {

        CacheItem item = getCache(cacheKey);
        return  commonUtil.toCommon(item);
    }


    public CacheItem getCache(CommonItem item)
    {

        String cacheKey =commonUtil.toPojo(item).getName();
        CacheItem cacheItem = mg_cache.get(cacheKey);

        if(cacheItem==null)
        {
            addCache(cacheKey);
            cacheItem = mg_cache.get(cacheKey);
        }

        return  cacheItem;
    }



    public void addCache(String cacheKey)
    {
        CacheItem item = mg_cache.get(cacheKey);

        if(item==null)
        {
            item =new CacheItem();
            item.setName(cacheKey);
            item.setCreateTime(System.currentTimeMillis());
            log.info("添加缓存："+cacheKey);
        }


        item.setLastModified(System.currentTimeMillis());

        mg_cache.put(cacheKey,item);

    }



    public void cleanOverTime()
    {
        TypeConvert convert =new TypeConvert();
        List<String> keys = convert.keytoList(mg_cache);

        for(String key : keys)
        {
            CacheItem item = mg_cache.get(key);

            if((System.currentTimeMillis() - item.getLastModified())>CacheConstant.CACHE_SYS_INTERVAL*5)
            {
                mg_cache.remove(key);
                log.info("清理缓存数据：" +key);
            }

        }

    }
}
