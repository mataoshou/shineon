package com.shineon.coder.action;

import com.shineon.coder.service.convert.CommonData;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDTO userDTO;

    @RequestMapping("/getUser")
    public CommonItem getUser(@RequestParam("id") int id)
    {
        return  userDTO.get(id);
    }


    @RequestMapping("/list")
    public CommonItem listUser()
    {
        return userDTO.listAll();

    }
    @RequestMapping("/edit")
//    @CrossOrigin(origins = "*")
    public void editUser(@RequestBody CommonItem item)
    {
        System.out.println(item.getErrorStatus() +"............." +item.getErrorReason());


        for(CommonData data : item.getDatas())
        {
            System.out.println(data.getId() +"................." +data.getTitle());

        }
    }

}
