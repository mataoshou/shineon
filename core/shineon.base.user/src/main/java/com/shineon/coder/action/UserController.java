package com.shineon.coder.action;


import com.esotericsoftware.minlog.Log;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    UserDTO userDTO;

    @Autowired
    ShineonUserCommonUtil commonUtil;


    @RequestMapping("/getUser")
    public CommonItem getUser()
    {
        log.info(".......................................");
        System.out.println("....................begin");
        ShineonUser user = userDTO.get(1);

        System.out.println("..............." + user.getUsername());
        return commonUtil.toCommon( user);
    }


    @RequestMapping("/listUser")
    public CommonItem listUser()
    {

        System.out.println("....................begin");
        List<ShineonUser> user = userDTO.list();

        System.out.println("..............." + user.size());
        return commonUtil.toCommon( user);
    }
}