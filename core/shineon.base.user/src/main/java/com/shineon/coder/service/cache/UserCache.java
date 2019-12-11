package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.constant.cache.UserCacheConstant;
import com.shineon.coder.kernel.util.SpringUtil;
import com.shineon.coder.kernel.util.StringUtil;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.QueryItemCommonUtil;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;
import com.shineon.coder.service.feign.UserFeign;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserCache extends IBaseCache<RmtUserInfo,RmtUserInfoCommonUtil> {

//    @Autowired
//    UserNoticeMessageClient messageClient;

    @Autowired
    QueryItemCommonUtil queryItemCommonUtil;

    @Autowired
    UserFeign userFeign;

    public void initCache()
    {
        setDTO(new RmtUserInfoCommonUtil());
        setCacheDecorate(UserCacheConstant.CACHE_PRE,UserCacheConstant.CACHE_LAST);
    }


    @Override
    protected boolean check(String key) {
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
    protected boolean success(String key,List<RmtUserInfo> pojos) {
//        return  messageClient.output().send(MessageBuilder.withPayload(key).build());
        return true;
    }

    @Override
    protected boolean fail(String key,List<RmtUserInfo> pojos, Exception e) {

        log.info("设置缓存失败：" +e.getMessage());
        return false;
    }

    @Override
    protected String getKeyParams(RmtUserInfo pojo) {
        return pojo.getId();
    }

    @Override
    protected CommonItem selectListByDB(QueryItem queryItem) {
        CommonItem item = queryItemCommonUtil.toCommon(queryItem);
        return  userFeign.list(item);
    }

    @Override
    protected RmtUserInfo updatePojoByDB(RmtUserInfo userInfo) {
        return dto.toPojo(userFeign.edit(dto.toCommon(userInfo)));
    }

    @Override
    protected void deletePojoByDB(RmtUserInfo userInfo) {
        userFeign.delete(dto.toCommon(userInfo));
    }

    @Override
    protected CommonItem getPojoByDB(QueryItem queryItem) {
        StringUtil util = SpringUtil.getBean(StringUtil.class);
        if(util.isUnEmpty(queryItem.getId())) {
            return userFeign.get(queryItemCommonUtil.toCommon(queryItem));
        }

        if(util.isUnEmpty(queryItem.getTitle())) {
            return userFeign.getByName(queryItemCommonUtil.toCommon(queryItem));
        }

        return null;
    }



}
