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


    // 添加角色
    @RequestMapping("/add")
    public String add(Role role) {
        // 添加角色
        roleServiceImpl.add(role);

        // 设置跳转路径 -> 注意重定向并不会加上 applicationContext.xml文件中配置的 内部资源视图解析器 的前后缀
        return "redirect:/role/list";
    }
}
