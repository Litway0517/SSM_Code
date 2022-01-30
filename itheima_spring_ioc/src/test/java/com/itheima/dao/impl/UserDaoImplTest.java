package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoImplTest {

    @Test
    public void save() {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 提供Bean的id参数(id就是唯一值) 然后spring框架会反射得到该对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println("测试: app.xml配置中的Bean标签的scope范围. signalton与prototype之间的区别");
        System.out.println(userDao1);   // com.itheima.dao.impl.UserDaoImpl@307f6b8c
        System.out.println(userDao2);   // com.itheima.dao.impl.UserDaoImpl@307f6b8c
        System.out.println("Bean的标签中的scope参数值默认是signalton, 即单例的. ");
        System.out.println("而prototype是多例的. ");
        System.out.println("单例与多例的区别: spring得到的Bean对象是放在容器中的, 当用户需要的时候请求spring加载一个Bean对象, " +
                "spring回去容器中取出来. 那么, 单例意味着, 每次取出来的都是同一个, 事务处理应该会和这个相关. " +
                "而多例意味着, 每次取出来的都是新的一个Bean对象, 都进行了一次新的实例化. ");

        userDao.save();

    }
}
