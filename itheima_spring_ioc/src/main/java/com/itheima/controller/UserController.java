package com.itheima.controller;

import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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

        /*
            ClassPathXmlApplicationContext 是从resources文件夹下读取配置文件 因此只需要给出配置文件的名称即可
            FileSystemXmlApplicationContext 是可以读取系统上任意地方的配置文件 因此需要给出全地址
         */


        // 使用spring解耦
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ApplicationContext app2 = new FileSystemXmlApplicationContext("F:\\IDEA-Java\\07-HM-SSM\\SSM_Code\\itheima_spring_ioc\\src\\main\\resources\\applicationContext.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) app.getBean("userService2");
        userServiceImpl.save();

        // 通过字节码对象去查找 但是超过两个时会报错
        UserServiceImpl userService = app.getBean(UserServiceImpl.class);
        userService.save();


        // 如果直接new一个service层, 那么将会是空指针, 因为没有userDao层
        // UserServiceImpl userService = new UserServiceImpl();
        // userService.save();

    }
}
