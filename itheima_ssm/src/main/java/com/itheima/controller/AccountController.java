package com.itheima.controller;


import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    /*
        spring容器默认是使用的JDK动态代理. 所以如果这里自动装配的是AccountServiceImpl的话, 就会报错, 因为这不是接口?
            此时需要在applicationContext.xml中开启: <aop:aspectj-autoproxy proxy-target-class="true"/>
        如果自动装配的是AccountService(接口), 那么就不需要配置.
     */
    @Autowired
    private AccountService accountService;


    // 保存. produces参数用了设置 向客户端回传字符串的类型. 类似于resp.setContentType
    @RequestMapping(value = "/save", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
        return "保存成功~";
    }


    // 查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("account_list");
        return modelAndView;
    }


}
