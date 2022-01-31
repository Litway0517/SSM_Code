package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * 静态工厂
 *
 * @author DELL_
 * @date 2022/01/31
 */
public class StaticFactory {

    /**
     * 得到用户DAO
     *
     * @return {@link UserDao}
     */
    public static UserDao getUserDao() {
        System.out.println("通过静态工厂去创建Bean...");
        return new UserDaoImpl();
    }

}
