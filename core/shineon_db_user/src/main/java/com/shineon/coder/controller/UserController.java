package com.shineon.coder.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.db.dao.ShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    ShineonUserMapper shineonUserMapper;

    @RequestMapping("/getUser")
    public ShineonUser get(int id)
    {

        ShineonUser user = shineonUserMapper.selectByPrimaryKey(id);
        System.out.println(user.getUsername());

        redisTemplate.opsForValue().set("user", JSON.toJSONString(user) );

        System.out.println( redisTemplate.opsForValue().get("user").toString());

        return user;
    }

}
