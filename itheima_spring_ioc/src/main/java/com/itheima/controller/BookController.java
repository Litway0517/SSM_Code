package com.itheima.controller;

import com.itheima.dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 本控制器
 *
 * @author DELL_
 * @date 2022/02/03
 */
public class BookController {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl bookDaoImpl = (BookDaoImpl) app.getBean("bookDaoImpl");
        bookDaoImpl.getBookByBookId();

    }

}
