package com.shineon.coder.controller;

import com.alibaba.fastjson.JSON;
import com.shineon.coder.db.dao.ShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

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

        Set<String> set =  redisTemplate.keys("u*");

        Iterator<String> iter = set.iterator();

        while (iter.hasNext())
        {
            System.out.println(".............."+iter.next());
        }

        System.out.println( redisTemplate.opsForValue().get("user").toString());

        return user;
//        return null;
    }

}
