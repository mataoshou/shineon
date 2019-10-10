package com.shineon.coder.service.feign;

import com.shineon.coder.kernel.constant.ServerNameConstant;
import com.shineon.coder.service.convert.CommonItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ServerNameConstant.SHINEON_DB_USER,fallback = UserBaseFallback.class)
public interface UserBase {

    @RequestMapping("/getUser")
    CommonItem getUser(@RequestParam("id") int id);


    @RequestMapping("/listUser")
    CommonItem listUser();

}
