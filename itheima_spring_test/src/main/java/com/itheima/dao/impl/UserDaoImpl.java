package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
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
        String sql ="SELECT * FROM `spring_test`.`sys_user`";
        BeanPropertyRowMapper<User> result = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query(sql, result);
        return userList;
    }


    /**
     * 添加用户
     *
     * @param user 用户
     */
    public Long addUser(User user) {

        /*
            如果存在并发情况, 那么同时插入了很多user. 而此时并没有获取到插入user的id, 所以就会错误的生成用户觉得关系表.
            所以这个查询语句不完全正确.
         */
        String sql = "INSERT INTO `spring_test`.`sys_user` VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return 0L;
    }

    /**
     * 添加用户角色rel
     *
     * @param userId  用户id
     * @param roleIds 角色id
     */
    public void addUserRoleRel(Long userId, Long[] roleIds) {
        String sql = "INSERT INTO `spring_test`.`sys_user_role` VALUES(?,?)";
        jdbcTemplate.update(sql, userId, roleIds);
    }


}
