package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * 角色DAO
 *
 * @author DELL_
 * @date 2022/02/11
 */
public interface RoleDao {


    /**
     * 列表
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> list();


    /**
     * 添加
     *
     * @param role 角色
     */
    public void add(Role role);


    /**
     * 被用户id角色
     *
     * @param id id
     * @return 根据用户id查询到的角色的相关信息
     */
    public List<Role> getRoleByUserId(Long id);
}
