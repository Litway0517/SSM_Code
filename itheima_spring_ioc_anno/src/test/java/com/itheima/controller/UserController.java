package com.itheima.controller;

import com.itheima.config.SpringConfiguration;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

        System.out.println("===============================");


        // 此时没有app.xml配置文件了. 使用以下代码测试
        AnnotationConfigApplicationContext app2 = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserServiceImpl userService2 = app2.getBean(UserServiceImpl.class);
        userService2.save();

        app2.close();
    }


}
