package com.shineon.coder.service.feign.fservice;

import com.shineon.coder.db.sql.pojo.ShineonUser;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.service.feign.base.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
