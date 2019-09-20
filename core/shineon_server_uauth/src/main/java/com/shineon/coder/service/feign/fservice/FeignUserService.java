package com.shineon.coder.service.feign.fservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.pojo.ShineonUser;
import com.shineon.coder.service.feign.base.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Component
public class FeignUserService {
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
