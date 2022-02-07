package com.itheima.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 将控制器放到spring容器中
@Controller

// 增该类的路由基地址
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() {

        User user = new User("test", "", 111);

        return user;

    }



    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        // 使用jackson转换
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(new User("test", "TGU", 6651));

        return json;
    }




    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() {
        // 使用Gson转换
        Gson gson = new Gson();
        String userToJson = gson.toJson(new User("litway", "TGU", 6653));

        return userToJson;
    }



    /*
        注解@ResponseBody是通知spring-mvc框架不要进行页面跳转, 而是进行字符串回传.
        响应头 响应行 响应体(ResponseBody) 自然是加上注解@ResponseBody
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {

        return "Hello World";
    }




    /*
        举一反三 再注入一个Response对象
     */
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("Hello world");
    }




    /*
        这里如果使用原始的方法存储到如中数据. 那么就在save5方法中加一个HttpServletRequest对象 框架会帮忙注入(实际上是创建)
        在方法中写一个HttpServletRequest其实并不常用 因为有了框架就用框架的解耦 不用这个
     */
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest req) {

        req.setAttribute("username", "酷丁鱼");

        return "forward:/jsp/success.jsp";
    }


    /*
        增加了@RequestMapping注解 spring-mvc框架会帮程序员调用相应方法
            如果发现方法中有相关参数 那么框架会自动注入 因为写框架的人已经设计好了

        同样的, 这个save4方法, 里面有一个形参model, spring-mvc调用这个方法时候, 发现了有这个参数. 那么就会帮程序员创建.
     */
    @RequestMapping("/quick4")
    public String save4(Model model) {
        // 拆分开 模型 和 数据
        model.addAttribute("username", "TGU");

        return "forward:/jsp/success.jsp";
    }


    /*
        这个save3()方法有实际参数 -> modelAndView 并且是 ModelAndView类型的.
        当spring-mvc框架调用save3()方法时, 就需要对此参数注入数据(谁调用谁负责传递参数).
        因此这个ModelAndView不为空(因为框架创建了这个对象), 所以就能够使用. 这也是一种注入方式
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {

        // 设置模型数据 -> addObject(key, value); 存储到域中
        modelAndView.addObject("username", "itheima");

        // 设置视图名称 -> 就是要展示结果数据的界面名称
        modelAndView.setViewName("/jsp/success.jsp");

        return modelAndView;

    }



    /*
        返回的是ModelAndView
     */
    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /*
            Model: 模型 是用来存放数据的
            View: 视图 是用来展示数据的
         */
        ModelAndView modelAndView = new ModelAndView();

        // 设置模型数据 -> addObject(key, value); 存储到域中
        modelAndView.addObject("username", "litway");

        // 设置视图名称 -> 就是要展示结果数据的界面名称
        modelAndView.setViewName("/jsp/success.jsp");


        return modelAndView;
    }


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
        /*
            将结果转发到success界面. forward: 默认时转发行为, 即省略forward也是可以的.
            但是如果需要进行重定向, 就必须加redirect:

            每次都会将 内部资源视图解析器InternalResourcesViewResolve 的自定义的前后缀拼接到返回的字符串上再返回

         */
        return "forward:/jsp/success.jsp";


        // 将结果重定向到success界面
        // return "redirect:/jsp/success.jsp";


        /*
            当注入了 内部资源视图解析器 的参数时: 就能够省略前缀后缀. 但是可读性很差.
            原本的return地址: /jsp/success.jsp
            配置之后的地址: success(这样一看就知道配置了前后缀, 所以需要查阅spring-mvc.xml配置文件)
         */
        // return "success";
    }


    @RequestMapping(value = "/login", params = {"username", "password"})
    public String login() {

        System.out.println("user login.....");

        return "redirect:/jsp/success.jsp";
    }






}
