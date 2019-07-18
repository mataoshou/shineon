package com.shineon.coder.controller;

import com.shineon.coder.service.mq.client.MataoMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {



    @Autowired
    MataoMessageClient mataoMessageClient;

    @RequestMapping("/send")
    public String sendMessage()
    {
        mataoMessageClient.output().send(MessageBuilder.withPayload("Hello World  AAAAA").build());

//        MessageUtil util  = SpringUtil.getBean(MessageUtil.class);
//
//        MessageItem item = util.empty();
//
//        System.out.println(item.getCode());



//        client.input().send(MessageBuilder.withPayload("Hello World  BBBBB").build());

        return  "success";
    }
}
