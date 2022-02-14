package com.itheima.controller;

import com.itheima.exception.MyException;
import com.itheima.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class DemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;

    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        demoServiceImpl.show1();
        //demoService.show2();
        //demoService.show3();
        //demoService.show4();
        //demoServiceImpl.show5();
        return "index";
    }

}
