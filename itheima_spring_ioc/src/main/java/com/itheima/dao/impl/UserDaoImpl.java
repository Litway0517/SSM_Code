package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 用户DAOImpl
 *
 * @author DELL_
 * @date 2022/01/30
 */
public class UserDaoImpl implements UserDao {
    /**
     * str列表
     */
    private List<String> strList;

    /**
     * 用户映射
     */
    private Map<String, User> userMap;

    /**
     * 属性
     */
    private Properties properties;


    /**
     * 用户名
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 集名称
     *
     * @param username 名字
     */
    public void setUserName(String username) {
        this.username = username;
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
     * str设置列表
     *
     * @param strList str列表
     */
    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    /**
     * 设置用户地图
     *
     * @param userMap 用户映射
     */
    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    /**
     * 设置属性
     *
     * @param properties 属性
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
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
        System.out.println(username + "=" + age);
        System.out.println("列表 -> " + strList + "\n" +
                            "集合 -> " + userMap + "\n" +
                            "properties -> " + properties);
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
