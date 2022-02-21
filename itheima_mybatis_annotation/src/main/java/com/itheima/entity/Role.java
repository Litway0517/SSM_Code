package com.itheima.entity;

/**
 * 角色
 *
 * @author DELL_
 * @date 2022/02/19
 */
public class Role {

    /**
     * id
     */
    private int id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色desc
     */
    private String roleDesc;

    /**
     * 得到id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 角色名字
     *
     * @return {@link String}
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色desc
     *
     * @return {@link String}
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置角色desc
     *
     * @param roleDesc 角色desc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
