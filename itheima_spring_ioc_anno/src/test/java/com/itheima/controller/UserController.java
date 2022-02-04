package com.itheima.controller;

import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用户控制器
 *
 * @author DELL_
 * @date 2022/02/04
 */
public class UserController {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = app.getBean(UserServiceImpl.class);
        userService.save();

        // 手动关闭容器, 就会出现了销毁方法
        app.close();



    }


}
