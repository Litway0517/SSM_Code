package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 列表
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> list(User user) {
        String sql2 =
                "SELECT u.`id`,u.`username`,u.`email`,u.`phoneNum`,r.`roleName` " +
                "FROM `sys_role` r,`sys_user` u " +
                "WHERE u.`id` = ? AND r.`id` IN( " +
                                                "SELECT ur.`roleId` " +
                                                "FROM `sys_user_role` ur " +
                                                "WHERE ur.`userId` = ? " +
                                                ")";

        String sql = "SELECT * FROM `sys_user`";
        BeanPropertyRowMapper<User> result = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query(sql2, result, user.getId(), user.getId());
        return userList;
    }
}
