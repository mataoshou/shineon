package com.shineon.coder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/getUser")
    public String getUser()
    {
        return redisTemplate.opsForValue().get("user").toString();
    }
}
