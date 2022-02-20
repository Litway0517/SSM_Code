package com.itheima.mapper;

import com.itheima.entity.Order;

import java.util.List;

/**
 * 顺序映射器
 *
 * @author DELL_
 * @date 2022/02/19
 */
public interface OrderMapper {

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Order}>
     */
    public List<Order> findAll();



}
