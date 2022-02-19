package com.itcast.mapper;

import com.itcast.entity.User;

/**
 * 用户映射器
 *
 * @author DELL_
 * @date 2022/02/18
 */
public interface UserMapper {

    /**
     * 保存
     *
     * @param user 用户
     */
    public void save(User user);

    /**
     * 发现通过id
     *
     * @param id id
     * @return {@link User}
     */
    public User findById(Integer id);


}
