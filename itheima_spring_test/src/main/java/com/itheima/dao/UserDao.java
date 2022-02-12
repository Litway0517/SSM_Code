package com.itheima.dao;

import com.itheima.domain.Role;
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
     * 被用户id角色
     *
     * @param id id
     * @return 根据用户id查询到的角色的相关信息
     */
    public List<Role> getRoleByUserId(Long id);
}
