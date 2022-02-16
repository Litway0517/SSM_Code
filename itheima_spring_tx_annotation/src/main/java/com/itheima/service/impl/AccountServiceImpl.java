package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("accountService")

/*
    增加@Transactional注解, 表示该业务类下面的所有方法均使用, 该事务控制. 以及控制的细节, 即参数, 也遵循这个注解.
    但是, 当某个方法上面, 也有了具体的@Transactional时, 就以方法上面的注解为主.
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED,
            timeout = TransactionDefinition.TIMEOUT_DEFAULT)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);

        // 产生错误
        int i = 1 / 0;

        accountDao.in(inMan,money);
    }
}
