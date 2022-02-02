package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/02
 */
public class UserServiceImpl implements UserService {

    /**
     * 保存
     */
    public void save() {
        /*
            这里是spring帮我们产生的DAO层 不需要我们在new UserDaoImpl();对象.
            当需要改动的时候只需要改配置文件内的代码而不需要改源码 -> 实现解耦
         */
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao3");
        userDao.save();
    }
}
