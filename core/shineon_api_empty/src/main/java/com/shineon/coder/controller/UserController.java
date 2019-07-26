package com.shineon.coder.controller;

//import com.shineon.coder.service.MataoBuild;
import com.shineon.coder.convert.CommonItem;
import com.shineon.coder.service.feign.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    MataoBuild build;

//    @Async("intervalExecutor")


    @Autowired
    UserService userService;


    @RequestMapping("/getUser")
    public CommonItem getUser(HttpServletRequest request)
    {


        logger.info("...........................begin");
        System.out.println("....................begin");
        return userService.getUser(1);
//        logger.info(Thread.currentThread().getName() + "....................getUser");
//        System.out.println(request.getSession().getId());
//
//        HttpSession session = request.getSession();
//        System.out.println(session.getAttribute("user"));
//
//        session.setAttribute("user","qwas");
//
//        build.build();
//
//        System.out.println("....................."+"finish");
//
//        return "success";
    }
}
