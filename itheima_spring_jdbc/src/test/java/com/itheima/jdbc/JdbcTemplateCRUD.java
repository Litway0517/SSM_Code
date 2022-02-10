package com.itheima.jdbc;


import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUD {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 查询特殊对象
    @Test
    public void testQuerySingle() {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `account`", Long.class);
        System.out.println(count);
    }



    // 查询单个对象
    @Test
    public void testQueryForOne() {
        Account result = jdbcTemplate.queryForObject("SELECT * FROM `account` WHERE `id`=?",
                new BeanPropertyRowMapper<Account>(Account.class), 2);
        System.out.println(result);
    }


    // 查询多个对象
    @Test
    public void testQueryAll() {
        List<Account> result = jdbcTemplate.query("SELECT * FROM `account`", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(result);
    }



    // 测试删除
    @Test
    public void testDelete() {
        int update = jdbcTemplate.update("DELETE FROM `account` WHERE `id`=?", 1);
        System.out.println(update);
    }




    // 测试更新
    @Test
    public void testUpdate() {
        int update = jdbcTemplate.update("UPDATE `account` SET `money`=? WHERE `id`=?", 10000, 2);
        System.out.println(update);
    }


}
