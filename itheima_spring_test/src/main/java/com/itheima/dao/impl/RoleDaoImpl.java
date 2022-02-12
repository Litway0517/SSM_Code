package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 列表
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> list() {
        String sql = "SELECT * FROM `sys_role`";
        BeanPropertyRowMapper<Role> handler = new BeanPropertyRowMapper<Role>(Role.class);
        List<Role> roleList = jdbcTemplate.query(sql, handler);
        return roleList;
    }
}
