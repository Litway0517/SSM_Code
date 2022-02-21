package com.itheima.mapper;

import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {


    @Select("select * from `sys_user_role` `ur`,`sys_role` `r` where ur.`roleId`=r.`id` and ur.`userId`=#{uId}")
    public List<Role> findByUid(int uId);



}
