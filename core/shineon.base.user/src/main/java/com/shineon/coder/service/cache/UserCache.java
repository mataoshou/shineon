package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.CacheItem;
import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.constant.cache.UserCacheConstant;
import com.shineon.coder.kernel.util.SpringUtil;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.QueryItemCommonUtil;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;
import com.shineon.coder.service.dto.UserDTO;
import com.shineon.coder.service.feign.UserFeign;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserCache extends BaseCache<RmtUserInfo,RmtUserInfoCommonUtil> {

    @Autowired
    UserNoticeMessageClient messageClient;

    @Autowired
    QueryItemCommonUtil queryItemCommonUtil;

    @Autowired
    UserFeign userFeign;

    public UserCache()
    {
        setDTO(new RmtUserInfoCommonUtil());
        setCacheDecorate(UserCacheConstant.CACHE_PRE,UserCacheConstant.CACHE_LAST);
    }


    @Override
    public boolean check(String key) {
//        CacheItem cacheItem = SysCache.single.getCache(key);
//
//        if((System.currentTimeMillis() - cacheItem.getLastModified())< CacheConstant.CACHE_SYS_INTERVAL)
//        {
//            log.info("本周期中 ,本缓存已更新，等待周期结束，下一周期再更新："+key +"周期时长（毫秒）："+CacheConstant.CACHE_SYS_INTERVAL);
//            return false;
//        }
        return true;
    }

    @Override
    public boolean success(String key, String body) {
        return  messageClient.output().send(MessageBuilder.withPayload(SysCache.single.getCommonItem(key).toJsonString()).build());
    }

    @Override
    public boolean fail(String key, String body, Exception e) {

        log.info("设置缓存失败：" +e.getMessage());
        return false;
    }

    @Override
    public String getKeyParams(RmtUserInfo pojo) {
        return pojo.getId();
    }

    @Override
    public CommonItem selectListByDB(QueryItem queryItem) {
        return  userFeign.list( queryItemCommonUtil.toCommon(queryItem));
    }

    @Override
    public CommonItem getPojoByDB(QueryItem queryItem) {
        return  userFeign.get( queryItemCommonUtil.toCommon(queryItem));
    }



}
