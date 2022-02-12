package com.itheima.dao.impl;

import com.itheima.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleDaoImplTest {

    @Autowired
    private RoleDaoImpl roleDaoImpl;


    @Test
    public void add() {

        roleDaoImpl.add(new Role(null, "testName", "testDesc"));
    }
}
