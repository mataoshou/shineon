package com.shineon.coder.service.mq;

import com.alibaba.fastjson.JSON;
import com.shineon.coder.service.mq.MessageItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageUtil {
    public MessageItem getMessage(String message)
    {
        MessageItem item =  JSON.parseObject(message,MessageItem.class);
        return item;
    }
}
