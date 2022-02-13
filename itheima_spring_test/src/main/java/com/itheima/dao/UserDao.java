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
     * @return {@link List}<{@link User}>
     */
    public List<User> list();


    /**
     * 添加用户
     *
     * @param user 用户
     */
    public Long addUser(User user);


    /**
     * 添加用户角色rel
     *
     * @param userId  用户id
     * @param roleIds 角色id
     */
    public void addUserRoleRel(Long userId, Long[] roleIds);


    /**
     * 删除
     *
     * @param userId 用户id
     */
    public void deleteUser(Long userId);


    /**
     * 删除用户角色rel
     *
     * @param userId 用户id
     */
    public void deleteUserRoleRel(Long userId);


    /**
     * 检查用户名和密码
     * 检查用户
     *
     * @param loginUser 用户
     * @return {@link User}
     */
    public User checkByUsernameAndPassword(User loginUser);

}
