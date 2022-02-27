package com.itcast.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateHandler extends BaseTypeHandler<Date> {
    // 将javaBean类型 转换为 mysql数据库需要的类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date o, JdbcType jdbcType) throws SQLException {
        // 这里将接收到的对象, 先向下转型

        long time = ((Date) o).getTime();
        preparedStatement.setLong(i, time);
    }


    // 将mysql数据库类型 转换为javaBean类型
    /*
        String s: 要转换的字段名称
        ResultSet resultSet: 查询出来的结果集
     */
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 根据字段名称去结果其中查询
        long aLong = resultSet.getLong(s);
        return new Date(aLong);
    }


    // 将mysql数据库类型 转换为JavaBean类型. 根据字段名称去结果其中查询
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        // 根据字段名称去结果其中查询
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }


    // 将mysql数据库类型 转换为JavaBean类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        // 根据字段名称去结果其中查询
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}
