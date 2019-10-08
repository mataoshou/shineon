package com.shineon.coder.service.dto;

import com.shineon.coder.db.sql.pojo.ShineonUser;
import com.shineon.coder.kernel.util.EmptyCheck;
import com.shineon.coder.service.bo.UserBO;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDTO extends ShineonUserCommonUtil{

    @Autowired
    UserBO userBO;


    public CommonItem get(int id)
    {
        return toCommon( userBO.getUser(id));
    }

    public CommonItem listAll()
    {
        return toCommon(userBO.list());
    }

    public void editUser(ShineonUser user)
    {
        if(user.getId()==0)
        {
            userBO.add(user);
        }
        else {
            userBO.update(user);
        }
    }

    public boolean check(ShineonUser user) throws Exception {
        if(!EmptyCheck.check(user.getUsername()))
        {
            throw new Exception("用户名不能为空");
        }

        return true;
    }

}
