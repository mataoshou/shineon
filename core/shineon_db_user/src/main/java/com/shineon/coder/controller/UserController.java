package com.shineon.coder.controller;

import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.db.service.UserService;
import com.shineon.coder.nodb.dao.GeneralDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @Autowired
    GeneralDao generalDao;

    @Autowired
    ShineonUserCommonUtil commonUtil;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/getUser")
    public CommonItem get(@RequestParam("id")int id)
    {
        logger.debug("getUser : ["+id+"]");
        ShineonUser user = userService.getUser(id);

        return commonUtil.toCommon(user);
    }


    @RequestMapping("/listUser")
    public CommonItem list()
    {
        logger.debug(".........................listUser");

        List list = new ArrayList(){
            {
                add(1);
                add(2);
                add(3);
            }
        };

        List<ShineonUser> users = userService.listUserByIds(list);

        return commonUtil.toCommon(users);
    }




}
