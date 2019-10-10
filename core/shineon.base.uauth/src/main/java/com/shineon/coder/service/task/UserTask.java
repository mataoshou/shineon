package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.constant.PoolConstant;
import com.shineon.coder.service.cache.SysCache;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@EnableScheduling
public class UserTask {

    @Autowired
    UserNoticeMessageClient messageClient;

    Logger logger = LoggerFactory.getLogger(UserTask.class);

    @Scheduled(fixedRate = 2000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild(){

        logger.info("...........用户更新完成，更新状态！！");

        messageClient.output().send(MessageBuilder.withPayload(SysCache.single.getCommonItem(CacheConstant.CACHE_SYS_USER)).build());
    }


}
