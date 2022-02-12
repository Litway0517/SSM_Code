package com.itheima.dao.impl;

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


    @Test
    public void list() {
        List<User> userList = userDaoImpl.list(new User(1L, null, null, null, null));
        System.out.println(userList);
    }
}
