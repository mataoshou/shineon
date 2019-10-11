package com.shineon.coder.service.cache;

import com.esotericsoftware.minlog.Log;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.kernel.common.cache.CacheUtil;
import com.shineon.coder.kernel.constant.cache.UserCacheConstant;
import com.shineon.coder.service.convert.CommonData;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.service.dto.UserDTO;
import com.shineon.coder.service.feign.UserBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserCache {


    @Autowired
    CacheUtil util;

    @Autowired
    ShineonUserCommonUtil commonUtil;


    @Autowired
    UserBase base;


    public void setCache(CommonItem item) throws Exception {
        CommonItem data = base.listUser();

        String keyData = getListKey(item);

        String keyLock = keyData +".LOCK";

        if(util.lock(keyLock))
        {
            Log.info("添加缓存数据：" +keyData);

            util.set(keyData,data);

            log.info(util.get(keyData).toJsonString());

            util.unlock(keyLock);
        }


    }


    public String getSingleKey(CommonItem item) throws Exception {
        return util.createCacheKey(UserCacheConstant.SINGLE_CACHE_PRE,UserCacheConstant.SINGLE_CACHE_LAST,item);
    }

    public String getListKey(CommonItem item) throws Exception {
        return util.createCacheKey(UserCacheConstant.LIST_CACHE_PRE,UserCacheConstant.LIST_CACHE_LAST,item);
    }

    public void commitListCache(CommonItem key,CommonItem data) throws Exception {
       util.set(getListKey(key),data);
    }

    public List<ShineonUser> getListCache(CommonItem key) throws Exception {
        return commonUtil.toPojoList(util.get(getListKey(key)));
    }


    public void commitSingleCache(CommonItem key,CommonItem data) throws Exception {
        util.set(getSingleKey(key),data);
    }

    public List<ShineonUser> getSingleCache(CommonItem key) throws Exception {
        return commonUtil.toPojoList(util.get(getSingleKey(key)));
    }


}
