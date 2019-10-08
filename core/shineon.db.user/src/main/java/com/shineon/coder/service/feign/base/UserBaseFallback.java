package com.shineon.coder.service.feign.base;

import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.CommonItemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBaseFallback implements UserBase {

    @Autowired
    CommonItemUtils itemUtils;
    @Override
    public CommonItem getUser(int id) {
        System.out.println("i am fail");

        return itemUtils.fail();
    }

    @Override
    public CommonItem listUser() {
        return null;
    }
}
