package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author DELL_
 * @date 2022/02/12
 */
public interface UserService {


    /**
     * 列表
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> list();


    /**
     * 添加
     *
     * @param user    用户
     * @param roleIds 角色id
     */
    public void add(User user, Long[] roleIds);


    /**
     * 删除
     *
     * @param userId 用户id
     */
    public void delete(Long userId);

    /**
     * 检查用户
     *
     * @param loginUser 用户
     * @return boolean
     */
    public User login(User loginUser);

}
