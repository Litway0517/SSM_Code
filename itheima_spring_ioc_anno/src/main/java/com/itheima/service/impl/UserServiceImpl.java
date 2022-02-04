package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/04
 */
public class UserServiceImpl implements UserService {

    // 创建一个DAO的实例, 采用setter方式注入DAO层. 这样实例化service层就会自动有DAO层
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
