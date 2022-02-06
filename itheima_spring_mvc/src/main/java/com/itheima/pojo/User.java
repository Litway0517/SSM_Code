package com.itheima.pojo;

/**
 * 用户
 *
 * @author DELL_
 * @date 2022/02/06
 */
public class User {

    /**
     * 用户名
     */
    private String username;
    /**
     * 地址
     */
    private String address;
    /**
     * 年龄
     */
    private Integer age;

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
     * 得到解决
     *
     * @return {@link String}
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 让年龄
     *
     * @return {@link Integer}
     */
    public Integer getAge() {
        return age;
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
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
