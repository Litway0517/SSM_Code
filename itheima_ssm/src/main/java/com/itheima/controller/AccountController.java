package com.itheima.controller;


import com.itheima.entity.Account;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;


    // 保存. produces参数用了设置 向客户端回传字符串的类型. 类似于resp.setContentType
    @RequestMapping(value = "/save", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String save(Account account) {
        accountServiceImpl.save(account);
        return "保存成功~";
    }


    // 查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountServiceImpl.findAll();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("account_list");
        return modelAndView;
    }


}
