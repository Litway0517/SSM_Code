package com.itheima.dotest;


import com.itheima.config.SpringConfiguration;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * 春天junit测试
 *
 * @author DELL_
 * @date 2022/02/04
 */

// 使用
@RunWith(SpringJUnit4ClassRunner.class)


// 通过 @ContextConfiguration 说明spring的配置文件. 使用的是xml的方式
// @ContextConfiguration("classpath:applicationContext.xml")

@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    // 创建一个待测试的对象 -> 然后加上@Autowired直接注入. 需要测试哪一个直接注入就能够测试. 因为此时该对象已经存在容器中了
    @Autowired
    private UserServiceImpl userServiceImpl;


    // 测试数据源
    @Autowired
    private DataSource dataSource;

    @Test
    public void testUserService() throws SQLException {

        userServiceImpl.save();
        dataSource.getConnection();
    }

}
