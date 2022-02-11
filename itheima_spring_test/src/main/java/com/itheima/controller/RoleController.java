package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 加上web层注解
@Controller

@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    // 查询所有的 角色列表
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleServiceImpl.list();
        // 设置Model部分
        modelAndView.addObject("roleList", roleList);

        // 设置View部分
        modelAndView.setViewName("role-list");

        return modelAndView;

    }
}
