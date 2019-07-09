package com.shineon.coder.controller;

import com.shineon.coder.stream.mclinet.UserMqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMqClient client;

    @RequestMapping("/getUser")
    public String getUser()
    {
//        client.output().send(MessageBuilder.withPayload("Hello World  AAAAA").build());

        client.input().send(MessageBuilder.withPayload("Hello World  BBBB").build());

        System.out.println(".......................................................................................");

        return "success";
    }
}
