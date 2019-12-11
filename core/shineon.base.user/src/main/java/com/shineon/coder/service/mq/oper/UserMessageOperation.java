package com.shineon.coder.service.mq.oper;

import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.service.cache.UserCache;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;
import com.shineon.coder.service.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserMessageOperation extends IBaseMessageOperation<RmtUserInfo, RmtUserInfoCommonUtil> {

    @Autowired
    UserCache cache;

    @Autowired
    UserFeign feign;

    @Override
    protected RmtUserInfo edit(RmtUserInfo userInfo) {
        try {
            log.info("edit user");
            cache.setCache(userInfo,true);
            return userInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RmtUserInfo delete(RmtUserInfo userInfo) {
        try {
            log.info("delete user");
            cache.delete(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
