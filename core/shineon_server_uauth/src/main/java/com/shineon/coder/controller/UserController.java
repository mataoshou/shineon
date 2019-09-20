package com.shineon.coder.controller;


import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.pojo.ShineonUser;
import com.shineon.coder.service.feign.base.UserBase;
import com.shineon.coder.service.feign.fservice.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    FeignUserService userService;

    @Autowired
    ShineonUserCommonUtil commonUtil;

    @RequestMapping("/getUser")
    public CommonItem getUser()
    {

        System.out.println("....................begin");
        ShineonUser user = userService.get(1);

        System.out.println("..............." + user.getUsername());
        return commonUtil.toCommon( user);
    }


    @RequestMapping("/listUser")
    public CommonItem listUser()
    {

        System.out.println("....................begin");
        List<ShineonUser> user = userService.list();

        System.out.println("..............." + user.size());
        return commonUtil.toCommon( user);
    }
}
