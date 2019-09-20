package com.shineon.coder.service.feign.base;

import com.shineon.coder.convert.CommonData;
import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.pojo.ShineonUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "shineon-db-user",fallback = UserBaseFallback.class)
public interface UserBase {

    @RequestMapping("/getUser")
    CommonItem getUser(@RequestParam("id") int id);


    @RequestMapping("/listUser")
    CommonItem listUser();


}
