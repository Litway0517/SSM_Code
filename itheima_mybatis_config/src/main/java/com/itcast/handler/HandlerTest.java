package com.itcast.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


// 因为 ORM 映射的时候, JavaBean的成员变量的类型 和 数据库的表的字段类型 不一样. 所以需要进行手动转换 -> 重写四个方法
public class HandlerTest extends BaseTypeHandler<Date> {

    // 设置非空参数. Java设置数据到数据库的回调方法
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {

    }

    // 将mysql数据库类型 转换为JavaBean类型. 获取可为空的结果. 根据columnName列名
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    // 获取可为空的结果. 根据columnIndex列索引
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    //
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
