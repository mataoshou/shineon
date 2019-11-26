package com.shineon.coder;


import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.constant.ServerConstant;
import com.shineon.coder.kernel.constant.SysConstant;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;
import com.shineon.coder.service.mq.MessageItem;
import com.shineon.coder.service.mq.client.UserNoticeMessageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTests {

    @Autowired
    UserNoticeMessageClient client;

    @Autowired
    RmtUserInfoCommonUtil commonUtil;

    @Test
    public void send() throws Exception
    {
        MessageItem item = new MessageItem();
        item.setOperType(MessageConstant.MESSAGE_OPER_EDIT);

        item.setSourceName(ServerConstant.SHINEON_SERVER_UAUTH);
        item.setDstName(ServerConstant.SHINEON_BASE_USER);

        item.setId("123");

        RmtUserInfo userInfo = new RmtUserInfo();
        userInfo.setId("1111");
        userInfo.setUsername("matao");

        item.setData(commonUtil.toCommon(userInfo));

        client.output().send(MessageBuilder.withPayload(item.toJsonString()).build());

    }
}
