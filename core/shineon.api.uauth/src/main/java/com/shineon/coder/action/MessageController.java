package com.shineon.coder.action;

import com.shineon.coder.service.mq.client.Matao1MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {



    @Autowired
    Matao1MessageClient mataoMessageClient;

    @RequestMapping("/send")
    public String sendMessage()
    {
        mataoMessageClient.output().send(MessageBuilder.withPayload("Hello World  AAAAA").build());


        return  "success";
    }
}
