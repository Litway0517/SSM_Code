package com.itheima.dotest;


import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunitTest {

    // 创建一个待测试的对象
    private UserServiceImpl userServiceImpl;

    @Test
    public void testUserService() {
        userServiceImpl.save();

    }

}
