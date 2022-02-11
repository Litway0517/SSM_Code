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

}
