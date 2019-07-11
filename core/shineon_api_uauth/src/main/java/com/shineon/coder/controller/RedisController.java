package com.shineon.coder.controller;

import com.shineon.coder.common.cache.RedisClient;
import com.shineon.coder.common.cache.RedisLock;
import com.shineon.coder.common.cache.RedisUtil;
import com.shineon.coder.common.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisClient client;

    @Autowired
    RedisUtil util;

    @RequestMapping("/lock")
    public String getlockRedis(@RequestParam("id")String  key)
    {
        RedisLock lock = new RedisLock();

        lock.setKey(key);

        lock.setLockType(RedisConstant.CACHE_KEY_LOCK_SYC);

        client.getLock(lock);

        System.out.println(util.get(key));

        return "success";
    }

    @RequestMapping("/getlock")
    public String getlock (@RequestParam("id")String  key)
    {

        System.out.println(util.get(key));

        return "success";
    }
}
