package com.itheima.pojo;

import java.util.List;

/**
 * UserVO
 *
 * @author DELL_
 * @date 2022/02/07
 */
public class UserVo {

    /**
     * 用户列表
     */
    private List<User> userList;

    /**
     * 获取用户列表
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * 设置用户列表
     *
     * @param userList 用户列表
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "UserVo{" +
                "userList=" + userList +
                '}';
    }
}
