package com.itheima.domain;

/**
 * 用户
 *
 * @author DELL_
 * @date 2022/02/02
 */
public class User {

    /**
     * 名字
     */
    private String name;
    /**
     * addr
     */
    private String addr;


    /**
     * 用户
     */
    public User() {
    }

    /**
     * 用户
     *
     * @param name 名字
     * @param addr addr
     */
    public User(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }


    /**
     * 得到名字
     *
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * 集名称
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 得到addr
     *
     * @return {@link String}
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置addr
     *
     * @param addr addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
