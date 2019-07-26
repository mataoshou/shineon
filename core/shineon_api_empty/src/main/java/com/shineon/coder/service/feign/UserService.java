package com.shineon.coder.service.feign;

import com.shineon.coder.convert.CommonItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shineon-server-uauth",fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping("/getUser")
    CommonItem getUser(@RequestParam("id") int id);
}
