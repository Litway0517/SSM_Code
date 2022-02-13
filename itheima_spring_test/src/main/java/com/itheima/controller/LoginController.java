package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {


    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public String login(User loginUser, HttpSession session) {

        User user = userServiceImpl.login(loginUser);
        if (user == null) {
            // 重定向
            return "redirect:/login.jsp";
        }

        session.setAttribute("user", user);
        return "redirect:/index.jsp";

    }



}
