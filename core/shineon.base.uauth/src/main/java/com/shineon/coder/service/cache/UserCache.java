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

    public void commitListCache(CommonItem item) throws Exception {
       util.set(getListKey(item),item);
    }

    public List<ShineonUser> getListCache(CommonItem item) throws Exception {
        return commonUtil.toPojoList(util.get(getListKey(item)));
    }


    public void commitSingleCache(CommonItem item) throws Exception {
        util.set(getSingleKey(item),item);
    }

    public List<ShineonUser> getSingleCache(CommonItem item) throws Exception {
        return commonUtil.toPojoList(util.get(getSingleKey(item)));
    }

}
