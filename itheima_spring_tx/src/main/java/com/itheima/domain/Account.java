package com.itheima.domain;

/**
 * 账户
 *
 * @author DELL_
 * @date 2022/03/02
 */
public class Account {

    /**
     * 名字
     */
    private String name;
    /**
     * 钱
     */
    private double money;

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
     * 得到钱
     *
     * @return double
     */
    public double getMoney() {
        return money;
    }

    /**
     * 集钱
     *
     * @param money 钱
     */
    public void setMoney(double money) {
        this.money = money;
    }
}
