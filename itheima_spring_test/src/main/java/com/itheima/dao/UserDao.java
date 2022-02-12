package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户DAO
 *
 * @author DELL_
 * @date 2022/02/12
 */
public interface UserDao {

    /**
     * 列表
     *
     * @param user 用户
     * @return {@link List}<{@link User}>
     */
    public List<User> list(User user);



}
