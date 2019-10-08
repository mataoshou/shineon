package com.shineon.coder.service.dto;

import com.shineon.coder.service.bo.UserBO;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDTO {

    @Autowired
    UserBO userBO;

    @Autowired
    ShineonUserCommonUtil commonUtil;
    public CommonItem get(int id)
    {
        return commonUtil.toCommon( userBO.getUser(id));
    }

    public CommonItem listAll()
    {
        return commonUtil.toCommon(userBO.list());
    }


}
