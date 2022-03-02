package com.itheima.service;

/**
 * 帐户服务
 *
 * @author DELL_
 * @date 2022/03/02
 */
public interface AccountService {

    /**
     * 转移
     *
     * @param outMan 出人
     * @param inMan  在人
     * @param money  钱
     */
    public void transfer(String outMan,String inMan,double money);

}
