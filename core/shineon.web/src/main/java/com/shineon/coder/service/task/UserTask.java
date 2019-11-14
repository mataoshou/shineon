package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.PoolConstant;
import com.shineon.coder.service.cache.UserCache;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@EnableScheduling
@Slf4j
public class UserTask {

    @Autowired
    UserNoticeMessageClient messageClient;

    @Autowired
    UserCache userCache;

    @Scheduled(fixedRate = 1000*10)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild() throws Exception {

//        log.info("开始更新用户数据！！");
//
//        CommonItem item = new CommonItem();
//        if(userCache.setCache(item)) {
//
//            log.info("完成用户数据更新！！");
//        }
//        else {
//            log.info("未更新用户数据，等待下次尝试！！");
//        }
    }


}
