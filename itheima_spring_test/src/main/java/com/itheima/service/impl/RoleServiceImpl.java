package com.itheima.service.impl;

import com.itheima.dao.impl.RoleDaoImpl;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务Impl
 *
 * @author DELL_
 * @date 2022/02/11
 */


// 业务层注解
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDaoImpl roleDaoImpl;

    /**
     * 列表
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> list() {
        List<Role> roleList = roleDaoImpl.list();
        return roleList;
    }

    /**
     * 添加
     *
     * @param role 角色
     */
    public void add(Role role) {
        roleDaoImpl.add(role);
    }
}
