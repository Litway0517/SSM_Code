package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.impl.RoleServiceImpl;
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

    @Autowired
    private RoleServiceImpl roleServiceImpl;


    // 用户界面展示
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userServiceImpl.list();
        modelAndView.addObject("userList", userList);

        // 设置试图
        modelAndView.setViewName("user-list");
        return modelAndView;
    }


    // 用户进入增加用户界面之后, 需要动态展示角色列表
    @RequestMapping("/addUI")
    public ModelAndView addUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleServiceImpl.list();
        modelAndView.addObject("roleList", roleList);

        // 跳转路径
        modelAndView.setViewName("user-add");
        return modelAndView;

    }


    // 实现添加用户
    @RequestMapping("/add")
    public String add(User user, Long[] roleIds) {
        userServiceImpl.add(user, roleIds);

        return "redirect:/user/list";
    }

}
