package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/04
 */

/*
    <bean id="userService" class="com.itheima.service.impl.UserServiceImpl" scope="prototype" />
    同样的使用注解代替上面的xml配置信息
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    // 创建一个DAO的实例, 采用setter方式注入DAO层. 这样实例化service层就会自动有DAO层

    /*
        <property name="userDao" ref="userDao" />
        不再使用xml的方式 + setter 方式注入DAO. 使用注解
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    /**
     * 保存
     */
    public void save() {
        userDao.save();

    }
}
