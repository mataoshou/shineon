package com.shineon.coder.service.feign.base;

import com.shineon.coder.convert.CommonData;
import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.CommonItemUtils;
import com.shineon.coder.pojo.ShineonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
