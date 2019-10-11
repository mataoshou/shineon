package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.MessageItem;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.MessageItemCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 系统状态缓存
 */
@Service
public class SysCache {

    public static SysCache single = new SysCache();

    MessageItemCommonUtil commonUtil = new MessageItemCommonUtil();

    public SysCache()
    {
        addCache(CacheConstant.CACHE_SYS_USER, (short) 0);
    }

    ConcurrentHashMap<String, CommonItem> mg_cache = new  ConcurrentHashMap<String, CommonItem>();

//    Object mg_lock = new Object();

    Logger logger = LoggerFactory.getLogger(SysCache.class);

    public MessageItem getCache(String cacheKey)
    {
        return commonUtil.toPojo(mg_cache.get(cacheKey));
    }


    public CommonItem getCommonItem(String cacheKey)
    {
        return mg_cache.get(cacheKey);
    }

    public void changeStatus(String cacheKey,short status)
    {
        CommonItem data = mg_cache.get(cacheKey);

        if(data==null)
        {
            logger.debug("不存在缓存数据："+cacheKey);
        }

        MessageItem item = commonUtil.toPojo(data);

        item.setStatus(status);

        mg_cache.put(cacheKey,commonUtil.toCommon(item));
    }

    public void addCache(String cacheKey,short initStatus)
    {
        MessageItem item =new MessageItem();

        item.setName(cacheKey);
        item.setInitStatus(initStatus);
        item.setStatus(initStatus);

        item.setInterval(CacheConstant.CACHE_SYS_INTERVAL);

        mg_cache.put(cacheKey,commonUtil.toCommon(item));

        logger.info("...........................添加缓存："+cacheKey);

    }
}
