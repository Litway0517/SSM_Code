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
