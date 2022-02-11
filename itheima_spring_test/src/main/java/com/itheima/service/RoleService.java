package com.itheima.service;


import com.itheima.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务
 *
 * @author DELL_
 * @date 2022/02/11
 */
public interface RoleService {

    /**
     * 列表
     *
     * @return {@link List}<{@link Role}>
     */
    public List<Role> list();

}
