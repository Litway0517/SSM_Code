package com.itheima.dao;

/**
 * 账户DAO
 *
 * @author DELL_
 * @date 2022/03/02
 */
public interface AccountDao {

    /**
     * 出
     *
     * @param outMan 出人
     * @param money  钱
     */
    public void out(String outMan,double money);

    /**
     * 在
     *
     * @param inMan 在人
     * @param money 钱
     */
    public void in(String inMan,double money);

}
