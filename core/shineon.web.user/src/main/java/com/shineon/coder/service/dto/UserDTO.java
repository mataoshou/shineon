package com.shineon.coder.service.dto;

import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import com.shineon.coder.service.feign.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDTO extends  ShineonUserCommonUtil {


    @Autowired
    UserBase base;

    public ShineonUser get(int id)
    {
        CommonItem item = base.getUser(id);
        return  toPojo(item);
    }


    public List<ShineonUser> list()
    {
        CommonItem item = base.listUser();
        return  toPojoList(item);
    }


}
