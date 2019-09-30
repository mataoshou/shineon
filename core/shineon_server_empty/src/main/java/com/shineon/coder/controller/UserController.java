package com.shineon.coder.controller;


import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.service.feign.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    public CommonItem getUser()
    {
        System.out.println("....................begin");
       return userService.getUser(1);
    }
}
