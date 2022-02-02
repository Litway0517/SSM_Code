package com.itheima.controller;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用户控制器
 *
 * @author DELL_
 * @date 2022/01/31
 */
public class UserController {

    public static void main(String[] args) {
        // 原始的实例化方式
        /*
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            userServiceImpl.save();
        */


        // 使用spring解耦
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) app.getBean("userService");
        userServiceImpl.save();


        // 如果直接new一个service层, 那么将会是空指针, 因为没有userDao层
        UserServiceImpl userService = new UserServiceImpl();
        userService.save();

    }
}
