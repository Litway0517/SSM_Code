package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    // 保存
    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        return null;
    }


    // 查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }


}
