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

    /**
     * 添加
     *
     * @param role 角色
     */
    public void add(Role role) {
        String sql = "INSERT INTO `sys_role` VALUES(?,?,?)";
        jdbcTemplate.update(sql, null, role.getRoleName(), role.getRoleDesc());
    }


    /**
     * 被用户id角色
     *
     * @param id id
     * @return 根据用户id查询到的角色的相关信息
     */
    public List<Role> getRoleByUserId(Long id) {
        String sql =
                "SELECT r.`id`,r.`roleName`,r.`roleDesc` " +
                        "FROM `sys_role` r " +
                        "WHERE r.`id` IN( " +
                        "SELECT `roleId` " +
                        "FROM `sys_user_role` " +
                        "WHERE `userId` = ? " +
                        ")";
        BeanPropertyRowMapper<Role> role = new BeanPropertyRowMapper<Role>(Role.class);
        List<Role> roleList = jdbcTemplate.query(sql, role, id);
        return roleList;

    }
}
