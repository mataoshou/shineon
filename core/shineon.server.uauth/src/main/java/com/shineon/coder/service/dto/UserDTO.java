package com.shineon.coder.service.dto;

import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.service.feign.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDTO {

    @Autowired
    UserBase base;

    @Autowired
    ShineonUserCommonUtil commonUtil;

    public ShineonUser get(int id)
    {
        CommonItem item = base.getUser(id);
        return  commonUtil.toPojo(item);
    }


    public List<ShineonUser> list()
    {
        CommonItem item = base.listUser();
        return  commonUtil.toPojoList(item);
    }


}
