package com.itheima.entity;

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
                '}';
    }
}
