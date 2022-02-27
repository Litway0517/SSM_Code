package com.itheima.mapper;

import com.itheima.entity.User;

import java.util.List;

/**
 * 用户映射器
 *
 * @author DELL_
 * @date 2022/02/27
 */
public interface UserMapper {


    /**
     * 查询所有
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> findAll();


    /**
     * 找到所有用户和角色
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> findAllUserAndRole();




}
