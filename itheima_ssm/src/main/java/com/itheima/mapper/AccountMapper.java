package com.itheima.mapper;

import com.itheima.entity.Account;

import java.util.List;

/**
 * 账户映射器
 *
 * @author DELL_
 * @date 2022/02/20
 */
public interface AccountMapper {

    /**
     * 保存
     */
    public void save();

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Account}>
     */
    public List<Account> findAll();




}
