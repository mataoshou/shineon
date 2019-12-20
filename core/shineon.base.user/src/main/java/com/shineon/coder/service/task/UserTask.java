package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.pool.PoolConstant;
import com.shineon.coder.service.cache.UserCache;
import com.shineon.coder.service.convert.util.CacheItemCommonUtil;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;
import com.shineon.coder.service.dto.UserDTO1;
import com.shineon.coder.service.mq.client.PrivilegeMessageClient;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import com.shineon.coder.service.mq.oper.OperationUtil;
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

    @Autowired
    UserDTO1 dto;

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

    @Autowired
    RmtUserInfoCommonUtil commonUtil;

    @Autowired
    PrivilegeMessageClient privilegeMessageClient;

    @Autowired
    CacheItemCommonUtil cacheItemCommonUtil;

    @Autowired
    OperationUtil operationUtil;

//    @Scheduled(fixedRate = 5000)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void sendMessage() throws Exception {
//        log.info("send message");
//        MessageItem item = new MessageItem();
//        item.setOperType(MessageConstant.MESSAGE_OPER_EDIT);
//
//        item.setSourceName(ServerConstant.SHINEON_SERVER_UAUTH);
//        item.setDstName(ServerConstant.SHINEON_BASE_USER);
//        item.setOperObjectName(RmtUserInfo.class.getSimpleName());
//
//        item.setId("123");
//
//        RmtUserInfo userInfo = new RmtUserInfo();
//        userInfo.setId("1111");
//        userInfo.setUsername("matao");
//
//        item.setData(commonUtil.toCommon(userInfo));
//
//        operationUtil.sendMessage(messageClient,item);
////        messageClient.output().send(MessageBuilder.withPayload(item.toJsonString()).setHeader("x-retries",3).build());
//    }

    @Scheduled(fixedRate = 3000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void sendMessage2() throws Exception {
//        log.info("send prvilege message");
//        MessageItem item = new MessageItem();
//        item.setOperType(MessageConstant.MESSAGE_OPER_EDIT);
//
//        item.setSourceName(ServerConstant.SHINEON_SERVER_UAUTH);
//        item.setDstName(ServerConstant.SHINEON_BASE_USER);
//        item.setOperObjectName(CacheItem.class.getSimpleName());
//        item.setMstype(MessageConstant.MESSAGE_TYPE_SINGLE);
//
//
//        item.setId("privilege123");
//
//        CacheItem cacheItem = new CacheItem();
//        cacheItem.setName("matao");
//
//        item.setData(cacheItemCommonUtil.toCommon(cacheItem));


//        operationUtil.sendMessage(messageClient,item);

//        log.info("开始发送消息" );

    }


}
