package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色DAOImpl
 *
 * @author DELL_
 * @date 2022/02/11
 */


// DAO层注解
@Repository
public class RoleDaoImpl implements RoleDao {


    /**
     * 列表
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> list() {
        return null;
    }
}
