package com.itheima.jdbc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUD {

    @Autowired
    private JdbcTemplate jdbcTemplate;


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
