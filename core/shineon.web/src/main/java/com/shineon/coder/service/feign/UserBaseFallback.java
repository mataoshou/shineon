package com.shineon.coder.service.feign;

import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBaseFallback implements UserBase {

    @Autowired
    UserDTO userDTO;

    @Override
    public CommonItem getUser(int id) {
        System.out.println("i am fail");

        return userDTO.fail();
    }

    @Override
    public CommonItem listUser() {
        return null;
    }
}
