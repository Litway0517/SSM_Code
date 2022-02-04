package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 用户DAOImpl
 *
 * @author DELL_
 * @date 2022/02/04
 */

/*
    <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl" scope="prototype" />
    这个标签表示的需要在spring容器中创建对象 具体创建的就是UserDaoImpl这个对象. 所以在这个类声明上加 @Component注解
    ("userDao")  起到id元素的作用
 */
//@Component("userDao")

// @Repository和@Component作用一样, 只不过可读性更强. 专门用于加在DAO层用于实例化Bean
@Repository("userDao")
public class UserDaoImpl implements UserDao {


    /**
     * 保存
     */
    public void save() {
        System.out.println("save running...");
    }
}
