package com.itheima.entity;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author DELL_
 * @date 2022/02/17
 */
public class User {

    /**
     * id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 订单列表
     */// 描述该用户的订单信息(可能有多个订单)
    private List<Order> orderList;


    /**
     * 用户
     */
    public User() {
    }

    /**
     * 用户
     *
     * @param id       id
     * @param username 用户名
     * @param password 密码
     */
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * 得到id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获得用户名
     *
     * @return {@link String}
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 得到密码
     *
     * @return {@link String}
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 得到生日
     *
     * @return {@link Date}
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 得到订单列表
     *
     * @return {@link List}<{@link Order}>
     */
    public List<Order> getOrderList() {
        return orderList;
    }

    /**
     * 设置订单列表
     *
     * @param orderList 订单列表
     */
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", orderList=" + orderList +
                '}';
    }
}
