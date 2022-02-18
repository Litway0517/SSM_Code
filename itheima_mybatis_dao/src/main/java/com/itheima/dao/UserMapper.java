package com.itheima.dao;

import com.itheima.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * 用户映射器
 *
 * @author DELL_
 * @date 2022/02/17
 */
public interface UserMapper {

    /**
     * 找到所有
     *
     * @return {@link List}<{@link User}>
     * @throws IOException IO异常
     */
    public List<User> findAll() throws IOException;


    /**
     * 发现通过id
     *
     * @return {@link User}
     */
    public User findById(int id);




}
