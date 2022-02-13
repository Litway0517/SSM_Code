package com.itheima.service.impl;

import com.itheima.dao.impl.RoleDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户服务Impl
 *
 * @author DELL_
 * @date 2022/02/12
 */


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private RoleDaoImpl roleDaoImpl;

    /**
     * 列表
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> list() {
        List<User> userList = userDaoImpl.list();

        /*
            因为每个用户对应的角色不一定是一个, 所以需要用List<Role>封装. 但是这样封装的话, 就不能一次性使用sql返回结果.
            所以, 在这里service层, 再进行一次查询! 通过用户id, 将角色id查询出来. 进而查询详细信息.
         */
        for (User user : userList) {
            List<Role> roleByUserId = roleDaoImpl.getRoleByUserId(user.getId());
            user.setRoles(roleByUserId);
        }

        return userList;
    }

    /**
     * 添加
     *
     * @param user    用户
     * @param roleIds 角色id
     */
    public void add(User user, Long[] roleIds) {
        // 这两个方法的调用, 实际上都需要事务控制. 同时成功或者同时失败(需要回滚数据库, 不能有数据改变)

        // 第一步 先插入用户信息
        Long userId = userDaoImpl.addUser(user);

        // 第二步 再插入用户的id与角色id关联信息
        userDaoImpl.addUserRoleRel(userId, roleIds);
    }

    /**
     * 删除
     *
     * @param userId 用户id
     */
    public void delete(Long userId) {
        // 第一步 删除关联表
        userDaoImpl.deleteUserRoleRel(userId);

        // 第二步 删除用户信息表
        userDaoImpl.deleteUser(userId);
    }
}
