package com.itheima.service.impl;

import com.itheima.entity.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    /**
     * 保存
     *
     * @param account 账户
     */
    public void save(Account account) {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.save(account);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Account}>
     */
    public List<Account> findAll() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            List<Account> accountList = accountMapper.findAll();
            sqlSession.close();

            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 报异常就返回null. 未查询到结果
        return null;
    }
}
