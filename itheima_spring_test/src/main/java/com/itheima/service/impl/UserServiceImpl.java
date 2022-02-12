package com.itheima.service.impl;

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


    /**
     * 用户DAOImpl
     */
    @Autowired
    private UserDaoImpl userDaoImpl;

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
            List<Role> roleByUserId = userDaoImpl.getRoleByUserId(user.getId());
            user.setRoles(roleByUserId);
        }

        return userList;
    }
}
