package com.shineon.coder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest request)
    {
        System.out.println(request.getSession().getId());

        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));

        session.setAttribute("user","qwas");

        return "success";
    }
}
