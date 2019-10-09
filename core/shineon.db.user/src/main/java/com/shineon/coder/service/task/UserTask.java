package com.shineon.coder.service.task;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.kernel.common.cache.SysCache;
import com.shineon.coder.kernel.constant.CacheConstant;
import com.shineon.coder.kernel.constant.PoolConstant;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class UserTask {

    @Autowired
    UserNoticeMessageClient messageClient;

    Logger logger = LoggerFactory.getLogger(UserTask.class);

    @Scheduled(fixedRate = 2000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild() throws Exception {

        logger.info("...........用户更新完成，更新状态！！");

        String json = JSONObject.toJSONString(SysCache.single.getCache(CacheConstant.CACHE_SYS_USER));
        messageClient.output().send(MessageBuilder.withPayload(json).build());
    }

}
