package com.shineon.coder.action;

import com.shineon.coder.db.sql.pojo.ShineonUser;
import com.shineon.coder.kernel.constant.action.UserControllerConstant;
import com.shineon.coder.service.convert.CommonData;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDTO userDTO;

    @RequestMapping(UserControllerConstant.GET)
    public CommonItem getUser(@RequestParam("id") int id)
    {
        return  userDTO.get(id);
    }


    @RequestMapping(UserControllerConstant.LIST)
    public CommonItem listUser()
    {
        return userDTO.listAll();

    }
    @RequestMapping(UserControllerConstant.EDIT)
    public CommonItem editUser(@RequestBody CommonItem item)
    {
        ShineonUser user = userDTO.toPojo(item);

        try {
            userDTO.check(user);
        } catch (Exception e) {
            return userDTO.fail(e.getMessage());
        }
        userDTO.editUser(user);

        System.out.println(item.getErrorStatus() +"............." +item.getErrorReason());

        for(CommonData data : item.getDatas())
        {
            System.out.println(data.getId() +"................." +data.getTitle());
        }

        return userDTO.success();
    }

}
