package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 将控制器放到spring容器中
@Controller
public class UserController {


    /*
        @RequestMapping注解是指: 请求映射. 即浏览器的请求到达时, 如果路径是quick. 那么就访问这个方法
     */
    @RequestMapping("/quick")
    public String save() {
        System.out.println("controller save running.....");

        /*
            直接return到需要跳转的界面的名称就行. 比之前的开发简单多了.
            之前是:
                req.getDispatcher("/quick/...").forward(req, resp);
         */
        return "success.jsp";
    }


}
