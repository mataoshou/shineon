package com.shineon.coder.controller;

import com.alibaba.fastjson.JSON;
import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.CommonItemUtils;
import com.shineon.coder.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.db.SqlWhere;
import com.shineon.coder.db.mergedao.IShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.db.service.UserService;
import com.shineon.coder.nodb.dao.GeneralDao;
import com.shineon.coder.nodb.pojo.GeneralItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    @Autowired
    CommonItemUtils commonItemUtils;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/getUser")
    public CommonItem get(@RequestParam("id")int id)
    {
        logger.debug("getUser : ["+id+"]");
        ShineonUser user = userService.getUser(id);

        return commonItemUtils.success(commonUtil.shineonUserToCommon(user));
    }


    @RequestMapping("/listUser")
    public List<ShineonUser> list()
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

        return users;
    }




}
