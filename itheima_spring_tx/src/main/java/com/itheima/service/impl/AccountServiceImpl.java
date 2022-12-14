package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

/**
 * 账户服务Impl
 *
 * @author DELL_
 * @date 2022/03/02
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);

        // 产生错误
        int i = 1 / 0;

        accountDao.in(inMan,money);
    }
}
