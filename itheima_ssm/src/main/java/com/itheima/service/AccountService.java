package com.itheima.service;

import com.itheima.entity.Account;

import java.util.List;

/**
 * 帐户服务
 *
 * @author DELL_
 * @date 2022/02/20
 */
public interface AccountService {

    /**
     * 保存
     */
    public void save(Account account);

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Account}>
     */
    public List<Account> findAll();



}
