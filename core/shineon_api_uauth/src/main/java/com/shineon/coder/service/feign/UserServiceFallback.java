package com.shineon.coder.service.feign;

import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.CommonItemUtils;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {
    @Override
    public CommonItem getUser(int id) {
        System.out.println("i am fail");
        CommonItemUtils utils = new CommonItemUtils();
        return utils.fail();
    }
}
