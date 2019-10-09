package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.constant.CacheConstant;
import com.shineon.coder.service.convert.CommonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 系统状态缓存
 */
@Service
public class SysCache {

    public static SysCache single = new SysCache();

    public SysCache()
    {
        addCache(CacheConstant.CACHE_SYS_USER, (short) 0);
    }

    ConcurrentHashMap<String, CommonData> mg_cache = new  ConcurrentHashMap<String, CommonData>();

//    Object mg_lock = new Object();

    Logger logger = LoggerFactory.getLogger(SysCache.class);

    public CommonData getCache(String cacheKey)
    {
        return mg_cache.get(cacheKey);
    }

    public void changeStatus(String cacheKey,short status)
    {
        CommonData data = mg_cache.get(cacheKey);

        if(data==null)
        {
            logger.debug("不存在缓存数据："+cacheKey);
        }

        data.setCurrentStatus1(status);

        data.setModifiedTime(new Date( System.currentTimeMillis()));

        mg_cache.put(cacheKey,data);
    }

    public void addCache(String cacheKey,short initStatus)
    {
        CommonData data = new CommonData();

        data.setName(cacheKey);
        data.setInitStatus(initStatus);
        data.setCurrentStatus1(initStatus);

        data.setCreateTime(new Date());

        data.setModifiedTime(new Date());

        data.setInterval(CacheConstant.CAHCE_SYS_INTERVAL);

        mg_cache.put(cacheKey,data);

        logger.info("...........................添加缓存："+cacheKey);

    }
}
