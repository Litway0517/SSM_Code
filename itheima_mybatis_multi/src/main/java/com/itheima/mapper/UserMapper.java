package com.itheima.mapper;

import com.itheima.entity.User;

import java.util.List;

public interface UserMapper {


    public List<User> findAll();


    public List<User> findAllUserAndRole();




}
