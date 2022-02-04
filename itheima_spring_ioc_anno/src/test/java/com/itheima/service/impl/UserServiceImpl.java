package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/04
 */

/*
    <bean id="userService" class="com.itheima.service.impl.UserServiceImpl" scope="prototype" />
    同样的使用注解代替上面的xml配置信息
 */
// @Component("userService")

@Service("userService")
public class UserServiceImpl implements UserService {

    // 为普通数据类型注入数据 -> 使用@Value注解
    // @Value("Tom")
    @Value("${jdbc.username}")      // 通过SpEL表达式注入到username字符串
    private String username;



    // 创建一个DAO的实例, 采用setter方式注入DAO层. 这样实例化service层就会自动有DAO层

    /*
        <property name="userDao" ref="userDao" />
        不再使用xml的方式 + setter 方式注入DAO. 使用注解
     */


    /*
        如果成员变量userDao上面仅有@Autowired注解 那么spring就会按照这个变量的类型(UserDao类型)到容器中去寻找.
        此时userDaoImpl上面有@Repository注解(有注解spring就会帮助程序员创建这个Bean, 容器中就会有一个UserDaoImpl对象),
            那么就会注入到这个变量中. 但是如果spring容器中有两个UserDaoImpl实例对象, spring就不知道具体将哪一个注入给userDao
            成员变量. 因此需要加上@Qualifier("id标识") 来确定.
     */
    // @Autowired
    // @Qualifier("userDao")

    @Resource(name="userDao")   // @Resource的注解作用相当于 @Autowired + @Qualifier
    private UserDao userDao;

    /**
     * 保存
     */
    public void save() {
        System.out.println(username);
        userDao.save();

    }





}
