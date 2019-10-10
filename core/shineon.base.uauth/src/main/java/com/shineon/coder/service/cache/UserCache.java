package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.kernel.common.cache.CacheUtil;
import com.shineon.coder.kernel.constant.cache.UserCacheConstant;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserCache {


    @Autowired
    CacheUtil util;

    @Autowired
    ShineonUserCommonUtil commonUtil;

    public String getSingleKey(CommonItem item) throws Exception {
        return util.createCacheKey(UserCacheConstant.USER_SINGLE_CACHE_PRVIEW,UserCacheConstant.USER_SINGLE_CACHE_LAST,item);
    }

    public String getListKey(CommonItem item) throws Exception {
        return util.createCacheKey(UserCacheConstant.USER_LIST_CACHE_PRVIEW,UserCacheConstant.USER_LIST_CACHE_LAST,item);
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
