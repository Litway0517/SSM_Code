package com.itheima.mapper;

import com.itheima.entity.Order;
import com.itheima.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 顺序映射器
 *
 * @author DELL_
 * @date 2022/02/19
 */
public interface OrderMapper {


    @Select(
            "SELECT o.`id` `oid`,o.`ordertime` `orderTime`,o.`total` `total`,o.`uid` `uid`, " +
                    "u.`id` `uid`,u.`username` `username`,u.`password` `password`,u.`birthday` `birthday` " +
            "FROM `order` o,`user3` u " +
            "WHERE u.`id`=o.`uid`"
    )
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "total", property = ""),
            @Result(column = "uid", property = "user.id"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password"),
            @Result(column = "birthday", property = "user.birthday")
    })
    public List<Order> findAll();



    @Select(
            "SELECT o.`id` `oid`,o.`ordertime` `orderTime`,o.`total` `total`,o.`uid` `uid` FROM `order` o"
    )
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "total", property = ""),
            @Result(
                    property = "user",  // 要封装的属性名称
                    column = "uid",     // 根据order表中哪个字段去查询user表的数据
                    javaType = User.class, // 查询到的结果类型
                    // select属性表示: 查询哪个接口中的方法获得数据. 实际上是引用UserMapper中的方法
                    one = @One(select = "com.itheima.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll2();


    // 增加这条查询语句, 是为了供User进行调用.
    @Select("select * from `order` where uid=#{uid}")
    public List<Order> findByUid();



}
