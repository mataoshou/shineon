package com.shineon.coder.service.feign;

import com.shineon.coder.convert.CommonItem;

public class UserServiceFallback implements UserService {
    @Override
    public CommonItem getUser(int id) {
        System.out.println("i am fail");
        return new CommonItem();
    }
}
