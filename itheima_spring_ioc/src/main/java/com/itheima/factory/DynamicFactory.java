package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * 动态工厂
 *
 * @author DELL_
 * @date 2022/01/31
 */
public class DynamicFactory {

    /**
     * 得到用户DAO
     *
     * @return {@link UserDao}
     */
    public UserDao getUserDao() {
        System.out.println("工厂配置实例...");
        return new UserDaoImpl();
    }


}
