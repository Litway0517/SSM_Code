package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.User;

import java.util.List;

/**
 * 书DAOImpl
 *
 * @author DELL_
 * @date 2022/02/03
 */
public class BookDaoImpl implements BookDao {

    // 成员变量
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 被书书id
     */
    public void getBookByBookId() {
        System.out.println(userList);
        System.out.println("查找图书...");
    }
}
