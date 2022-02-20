package com.itheima.mapper;

import com.itheima.entity.Order;
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



}
