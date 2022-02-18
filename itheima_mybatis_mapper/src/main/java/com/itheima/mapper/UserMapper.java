package com.itheima.mapper;

import com.itheima.entity.User;

import java.util.List;

/**
 * 用户映射器
 *
 * @author DELL_
 * @date 2022/02/18
 */
public interface UserMapper {

    /**
     * 找到条件
     *
     * @param user 用户
     * @return {@link List}<{@link User}>
     */
    public List<User> findByCondition(User user);

    /**
     * 发现由ids
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> findByIds(List<Integer> ids);




}
