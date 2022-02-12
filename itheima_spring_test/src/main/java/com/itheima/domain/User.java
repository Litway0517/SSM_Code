package com.itheima.domain;

import java.util.List;

/**
 * 用户
 *
 * @author DELL_
 * @date 2022/02/11
 */
public class User {

    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 全国矿工工会电话
     */
    private String phoneNum;

    /**
     * 角色
     */
    private List<Role> roles;


    public User() {
    }
    public User(Long id, String username, String email, String password, String phoneNum) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    /**
     * 得到id
     *
     * @return {@link Long}
     */
    public Long getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(Long id) {
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
     * 获得电子邮件
     *
     * @return {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 得到电话num
     *
     * @return {@link String}
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机num
     *
     * @param phoneNum 全国矿工工会电话
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 得到角色
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * 设置角色
     *
     * @param roles 角色
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roles=" + roles +
                '}';
    }
}
