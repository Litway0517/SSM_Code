package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 加上web层注解
@Controller

@RequestMapping("/role")
public class RoleController {



    // 查询所有的 角色列表
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();


        return modelAndView;

    }
}
