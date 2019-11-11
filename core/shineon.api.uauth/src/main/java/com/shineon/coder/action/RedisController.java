//package com.shineon.coder.action;
//
//import com.shineon.coder.kernel.common.cache.RedisClient;
//import com.shineon.coder.kernel.common.cache.RedisLock;
//import com.shineon.coder.kernel.common.cache.RedisUtil;
//import com.shineon.coder.kernel.constant.RedisConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RedisController {
//
//    @Autowired
//    RedisClient client;
//
//    @Autowired
//    RedisUtil util;
//
//    @RequestMapping("/lock")
//    public String getlockRedis(@RequestParam("id")String  key)
//    {
//        RedisLock lock = new RedisLock();
//
//        lock.setKey(key);
//
//        lock.setLockType(RedisConstant.CACHE_KEY_LOCK_SYC);
//
//        util.lock(key,lock);
//
//        System.out.println(util.get(key));
//
//        return "success";
//    }
//
//    @RequestMapping("/getlock")
//    public String getlock (@RequestParam("id")String  key)
//    {
//
//        System.out.println(util.get(key));
//
//        return "success";
//    }
//}
