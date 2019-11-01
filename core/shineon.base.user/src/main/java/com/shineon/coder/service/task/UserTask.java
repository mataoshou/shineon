package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.PoolConstant;
import com.shineon.coder.service.cache.SysCache;
import com.shineon.coder.service.cache.UserCache;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.dto.UserDTO;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
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

    @Autowired
    UserDTO dto;

    @Scheduled(fixedRate = 1000*10)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild() throws Exception {

//        log.info("开始更新用户数据！！");



//        if(userCache.setCache(null,dto.list())) {
//            log.info("完成用户数据更新！！");
//        }
//        else {
//            log.info("未更新用户数据，等待下次尝试！！");
//        }
    }


//    @Scheduled(fixedRate = 500)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void sendMessage() throws Exception {
//        log.info("send Message matao");
//        messageClient.output().send(MessageBuilder.withPayload(SysCache.single.getCommonItem("matao").toJsonString()).build());
//    }


}
