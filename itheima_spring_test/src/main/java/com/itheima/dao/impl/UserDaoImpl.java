package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Long addUser(final User user) {
        /*
            如果存在并发情况, 那么同时插入了很多user. 而此时并没有获取到插入user的id, 所以就会错误的生成用户觉得关系表.
            所以这个查询语句不完全正确.
         */
        // String sql = "INSERT INTO `spring_test`.`sys_user` VALUES(?,?,?,?,?)";
        // jdbcTemplate.update(sql, null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始的jdbc完成PreparedStatement的组建
                String sql = "INSERT INTO `spring_test`.`sys_user` VALUES(?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                // 设置参数
                ps.setObject(1, null);
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getPhoneNum());
                return ps;
            }
        };

        GeneratedKeyHolder gkl = new GeneratedKeyHolder();
        // 使用另一个update方法! update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder )
        jdbcTemplate.update(psc, gkl);
        return gkl.getKey().longValue();
    }

    /**
     * 添加用户角色rel
     *
     * @param userId  用户id
     * @param roleIds 角色id
     */
    public void addUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            String sql = "INSERT INTO `spring_test`.`sys_user_role` VALUES(?,?)";
            jdbcTemplate.update(sql, userId, roleId);
        }
    }


    /**
     * 删除用户角色rel
     *
     * @param userId 用户id
     */
    public void deleteUserRoleRel(Long userId) {
        String sql = "DELETE FROM spring_test.`sys_user_role` WHERE `userId`=? ";
        jdbcTemplate.update(sql, userId);
    }


    /**
     * 删除
     *
     * @param userId 用户id
     */
    public void deleteUser(Long userId) {
        String sql = "DELETE FROM spring_test.`sys_user` WHERE `id`=? ";
        jdbcTemplate.update(sql, userId);

    }


    /**
     * 检查用户名和密码
     * 检查用户
     *
     * @param loginUser 用户
     * @return {@link User}
     */
    public User checkByUsernameAndPassword(User loginUser) {
        String sql =
                "select u.`id`,u.`username`,u.`email`,u.`password`,u.`phoneNum` " +
                "from `spring_test`.`sys_user` u " +
                "WHERE u.`username` = ? and u.`password` = ? ";
        BeanPropertyRowMapper<User> resultHandler = new BeanPropertyRowMapper<User>(User.class);
        User checkUser = jdbcTemplate.queryForObject(sql, resultHandler, loginUser.getUsername(), loginUser.getPassword());
        return checkUser;
    }
}
