package com.itheima.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itheima.pojo.User;
import com.itheima.pojo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 将控制器放到spring容器中
@Controller

// 增该类的路由基地址
@RequestMapping("/user")
public class UserController {

    /*
        @RequestParam注解的使用
            - 当方法为 -> getReqParams(String username) 时, 前端的请求URL地址必须有参数username才能够注入到这个方法的形参中.
              如果前端的URL地址写错了参数 username 为 name, 那么该方法的形参username就收不到参数值.

          此时可以使用@RequestParam注解结局.
            - @RequestParam(value = "name")表示显示的绑定 前端URL地址中的name参数的值就是映射给此方法的username的.
              所以此方法的形参就能够接收到前端的参数值了.

      @RequestParam的参数:
        - value: 用来显示绑定前端请求地址中的参数绑定给相应方法中形式参数
        - required: 该参数默认为true. 表示前端必须携带该参数请求, 否则404报错. 相反, 改为false的话就不会
        - defaultValue: 前端不携带参数时, 默认赋值

     */
    @RequestMapping("/quick16")
    @ResponseBody
    public void getReqParams(@RequestParam(value = "name", required = false,
                                            defaultValue = "itcast") String username)
    {
        System.out.println(username);
    }




    /*
        第二种方式获取前端参数: 参数类型是List<User>
        注意, 响应方法的形参前面需要加上@RequestBody注解

        在响应方法的形式参数前面加上@RequestBody注解
        且前端的请求标头的参数形式为application/json;charset=utf-8类型 那么能够直接接收List<User>集合参数
     */
    @RequestMapping("/quick15")
    @ResponseBody
    public void getReqListParams2(@RequestBody List<User> userList) {
        System.out.println(userList);
    }



    /*
        接受前端传过来的集合类型的参数. List<User>. 但是这时需要使用View Object的思想.
        VO: 是指, 集合中元素的类型构成的类. 这个VO类本身有一个成员变量, 就是List<T> tList.
     */
    @RequestMapping("/quick14")
    @ResponseBody
    public void getReqListParams(UserVo userVo) {
        System.out.println("集合类型的参数 集合的每一个元素为User类型的实体类 -> " + userVo);

    }



    /*
        前端传递的参数为: http://localhost/itheima_spring_mvc/user/quick13?strs=aaa&strs=17&strs=15a
        那么, 可以使用一个数组收集起来.
     */
    @RequestMapping("/quick13")
    @ResponseBody
    public void getReqParamsToArgs(String[] strs) {
        System.out.println("请求参数封装为数组 -> " + Arrays.asList(strs));
    }



    /*
        在对应的响应方法中, 增加一个形式参数即可. springMVC框架就会自动的将前端的参数值注入到这个参数中.
        注意名称需要和Bean的成员变量的名称一样.
     */
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void getReqParamsToBean(User user) {
        System.out.println(user);
    }



    /*
        获取前端传递过来的普通参数. 浏览器传过来的参数都是字符串类型.
        即请求地址 -> http://ip:port/工程路径?username=xx&age=xx 中, username和age传给后端的都是字符串类型
     */
    @RequestMapping(value = "/quick11")
    // 该方法返回的是void. 以及@ResponseBody这个注解 表示不进行页面跳转 即后面是空白界面
    @ResponseBody
    public void getReqParams(String username, Integer age) {
        System.out.println(username + " " + age);
    }



    /*
        返回集合数据类型 -> List<User>
        因为配置了 处理映射器 中的转换器成员, 因此就会将List集合直接转成JSON对象回传给前端
     */
    @RequestMapping("/quick10")
    @ResponseBody
    public List<User> save10() {
        List<User> list = new ArrayList<User>();
        list.add(new User("test1", "aa", 111));
        list.add(new User("test2", "bb", 222));

        return list;

    }


    /*
        通过Jackson工具包转换Bean -> JSON字符串
     */
    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        // 使用jackson转换
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(new User("test", "TGU", 6651));

        return json;
    }



    /*
        通过Gson工具包转换Bean -> JSON字符串
     */
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

        // 这里相当于直接写好了View
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
