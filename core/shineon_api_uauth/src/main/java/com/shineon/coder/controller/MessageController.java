package com.shineon.coder.controller;

import com.shineon.coder.common.message.MessageItem;
import com.shineon.coder.common.message.MessageUtil;
import com.shineon.coder.common.util.SpringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class MessageController {


    @RequestMapping("/send")
    public String sendMessage()
    {

        MessageUtil util  = SpringUtil.getBean(MessageUtil.class);

        MessageItem item = util.empty();

        System.out.println(item.getCode());


        return  "success";
    }
}
