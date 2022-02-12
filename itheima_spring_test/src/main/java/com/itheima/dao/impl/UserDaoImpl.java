package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAOImpl
 *
 * @author DELL_
 * @date 2022/02/12
 */


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 列表
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> list() {
        String sql ="SELECT * FROM `sys_user`";
        BeanPropertyRowMapper<User> result = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query(sql, result);
        return userList;
    }
}
