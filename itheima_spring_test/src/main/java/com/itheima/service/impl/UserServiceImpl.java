package com.itheima.service.impl;

import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/12
 */


@Service
public class UserServiceImpl implements UserService {


    /**
     * 用户DAOImpl
     */
    @Autowired
    private UserDaoImpl userDaoImpl;

    /**
     * 列表
     *
     * @param user 用户
     * @return {@link List}<{@link User}>
     */
    public List<User> list(User user) {
        List<User> userList = userDaoImpl.list(user);
        return userList;
    }
}
