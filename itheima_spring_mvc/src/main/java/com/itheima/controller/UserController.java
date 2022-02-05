package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 将控制器放到spring容器中
@Controller

// 增该类的路由基地址
@RequestMapping("/user")
public class UserController {


    /*
        @RequestMapping注解是指: 请求映射. 即浏览器的请求到达时, 如果路径是quick. 那么就访问这个方法
        @RequestMapping注解能够用在方法上, 也能够用在类名上.

        - 仅使用在方法上是:
            如save()方法上的quick -> http://ip:port/quick

        - 在类名称上使用@RequestMapping("/xxx"). 并且方法名字上也是用@RequestMapping("/quick")
            那么路由地址是 -> http://ip:port/xxx/quick
            即是类名称上面的地址 拼接 方法名字上的地址构成的.

        - params = {"username"} : 表示的是, 前端请求地址中参数中必须包含参数username=xxx
            (http://ip:port/xxx/quick?username=xx)  否则报错.
     */
    // @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    @RequestMapping(value = "/quick", method = RequestMethod.GET)
    public String save() {
        System.out.println("controller save running.....");

        /*
            直接return到需要跳转的界面的名称就行. 比之前的开发简单多了.
                这里面return是相对地址.
                例如: 请求地址是http://ip:port/abc/
                    那么return的地址时http://ip:port/abc/success.jsp
                    所以这个地址有可能不正确
            之前是:
                req.getDispatcher("/quick/...").forward(req, resp);
         */
        // 将结果转发到success界面
        return "forward:/success.jsp";

        // 将结果重定向到success界面
        // return "redirect:/success.jsp";
    }


}
