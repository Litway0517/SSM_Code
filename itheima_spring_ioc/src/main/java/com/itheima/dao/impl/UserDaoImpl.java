package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

/**
 * 用户DAOImpl
 *
 * @author DELL_
 * @date 2022/01/30
 */
public class UserDaoImpl implements UserDao {


    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 集名称
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设定年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 用户DAOImpl
     * 无参构造方法
     * 无参构造方法被调用一次, 那么这个Bean对象就被创建一次
     */
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建....");
    }

    /**
     * 保存
     */
    public void save() {
        System.out.println("save running......");
    }

    /**
     * 初始化
     */
    public void init() {
        System.out.println("初始化方法......");
    }


    /**
     * 摧毁
     * 销毁
     */
    public void destroy() {
        System.out.println("销毁方法......");
    }


}
