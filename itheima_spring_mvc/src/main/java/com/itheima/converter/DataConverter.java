package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据转换器
 *
 * @author DELL_
 * @date 2022/02/09
 */
/*
    这个Converter的接口是springMVC框架的一个转换接口.
    需要两个泛型.
    S: 表示的是传入的原本的时间格式是什么样的, 这里面为String.
    T: 表示转换之后的格式是什么类型, 这里面是util包下的Date
 */
public class DataConverter implements Converter<String, Date> {

    // 如期字符串转换为真正的日期格式
    public Date convert(String data) {
        // 这里的格式最好集成到配置文件
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
