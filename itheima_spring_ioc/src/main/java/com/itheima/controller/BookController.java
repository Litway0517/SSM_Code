package com.itheima.controller;

import com.itheima.dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookController {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl bookDaoImpl = (BookDaoImpl) app.getBean("bookDaoImpl");
        bookDaoImpl.getBookByBookId();

    }

}
