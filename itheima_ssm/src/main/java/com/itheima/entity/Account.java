package com.itheima.entity;

/**
 * 账户
 *
 * @author DELL_
 * @date 2022/02/20
 */
public class Account {


    /**
     * id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 钱
     */
    private Double money;

    /**
     * 得到id
     *
     * @return int
     */
    public Integer getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 得到钱
     *
     * @return {@link Double}
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 集钱
     *
     * @param money 钱
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
