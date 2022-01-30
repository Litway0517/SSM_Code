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
        userDao.save();

    }
}
