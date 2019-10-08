package com.shineon.coder.action;

import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDTO userDTO;


    @RequestMapping("/getUser")
    public CommonItem getUser(HttpServletRequest request)
    {
        logger.info("...........................begin");
        System.out.println("....................begin");
        ShineonUser user = userDTO.get(1);

        return userDTO.toCommon(user);
    }
}
