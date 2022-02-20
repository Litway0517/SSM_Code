package com.itheima.service.impl;

import com.itheima.entity.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {


    // 从spring容器中注入mapper
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 保存
     *
     * @param account 账户
     */
    public void save(Account account) {
        // 每次都会加载一次SqlMapConfig.xml文件. 交给框架
        /*try {
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.save(account);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 上面是手写方式, 下面是spring-mybatis集成方式
        accountMapper.save(account);

    }

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Account}>
     */
    public List<Account> findAll() {
        /*try {
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
        return null;*/

        // 上面是手写方式, 下面是spring-mybatis集成方式
        return accountMapper.findAll();
    }
}
