package com.shineon.coder.controller;

import com.shineon.coder.service.MataoBuild;
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

    @Autowired
    MataoBuild build;

//    @Async("intervalExecutor")
    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest request)
    {
        logger.info(Thread.currentThread().getName() + "....................getUser");
        System.out.println(request.getSession().getId());

        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));

        session.setAttribute("user","qwas");

        build.build();

        System.out.println("....................."+"finish");

        return "success";
    }
}
