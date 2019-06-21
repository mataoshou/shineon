package com.shineon.coder.controller;

import com.shineon.coder.db.dao.ShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    ShineonUserMapper mapper;

    @RequestMapping("/get")
    public ShineonUser get(int id)
    {

        ShineonUser user = mapper.selectByPrimaryKey(id);
        System.out.println(user.getUsername());

        return user;
    }

}
