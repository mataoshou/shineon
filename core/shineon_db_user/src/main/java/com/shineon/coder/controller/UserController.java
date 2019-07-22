package com.shineon.coder.controller;

import com.alibaba.fastjson.JSON;
import com.shineon.coder.db.dao.ShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.nodb.dao.GeneralDao;
import com.shineon.coder.nodb.pojo.GenerallItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    ShineonUserMapper shineonUserMapper;

    @Autowired
    GeneralDao generalDao;

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


        GenerallItem item = new GenerallItem();
        item.setContent("111111111111111" +"2aaaaa2222");

        item.setType(100);
        generalDao.insert(item);


        System.out.println(item.getId());

        List<GenerallItem> list = generalDao.findall(GenerallItem.class);

        for(GenerallItem item1: list)
        {
            System.out.println("........"+item1.getId() +"....." +item1.getType() +"...." +item1.getContent());
        }



        List<GenerallItem> list1 = generalDao.findall("2222");

        for(GenerallItem item1: list1)
        {
            System.out.println("111111111........"+item1.getId() +"....." +item1.getType()+"...." +item1.getContent());
        }


        List<GenerallItem> list2 = generalDao.findall(0);


        for(GenerallItem item1: list2)
        {
            System.out.println("2222222........"+item1.getId() +"....." +item1.getType()+"...." +item1.getContent());
        }


        return user;
//        return null;
    }

}
