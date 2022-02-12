package com.itheima.dao.impl;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private RoleDaoImpl roleDaoImpl;


    @Test
    public void list() {
        List<User> userList = userDaoImpl.list();
        System.out.println(userList);
    }



    @Test
    public void getRoleByUserId() {
        List<Role> roleByUserId = roleDaoImpl.getRoleByUserId(1L);
        System.out.println(roleByUserId);

    }
}
