package com.itheima.entity;

import java.util.Date;

/**
 * 订单
 *
 * @author DELL_
 * @date 2022/02/19
 */
public class Order {

    /**
     * id
     */
    private int id;
    /**
     * 订单时间
     */
    private Date orderTime;
    /**
     * 总计
     */
    private Double total;

    /**
     * 用户
     */// 表示当前订单属于哪一个用户
    private User user;

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
     * 得到订单时间
     *
     * @return {@link Date}
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置订单时间
     *
     * @param orderTime 订单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 得到总
     *
     * @return {@link Double}
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置总
     *
     * @param total 总计
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 获取用户
     *
     * @return {@link User}
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置用户
     *
     * @param user 用户
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
