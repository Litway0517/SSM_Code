package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userServiceImpl.list();
        modelAndView.addObject("userList", userList);

        // 设置试图
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
