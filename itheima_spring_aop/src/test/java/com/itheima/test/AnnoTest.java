package com.itheima.test;

import com.itheima.proxy.annotation.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 配置运行引擎
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTest {

    // 注意这个导包需要导annotation包下面的. 因为上面的读取配置文件变了
    @Autowired
    private TargetInterface target;


    @Test
    public void save() {
        target.save();
    }



}
