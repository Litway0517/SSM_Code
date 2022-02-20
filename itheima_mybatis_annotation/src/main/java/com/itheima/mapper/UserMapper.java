package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户映射器
 *
 * @author DELL_
 * @date 2022/02/19
 */
public interface UserMapper {

    /**
     * 保存
     */
     @Insert(value = "insert into `user3` values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    /**
     * 更新
     */
     @Update(value = "update `user3` set username=#{username},password=#{password},birthday=#{birthday} where id=#{id}")
    public void update(User user);

    /**
     * 删除
     */
     @Delete(value = "delete from `user3` where id=#{id}")
    public void delete(int id);

    /**
     * 发现通过id
     *
     * @return {@link User}
     */
     @Select(value = "select * from `user3` where id=#{id}")
    public User findById(int id);

    /**
     * 找到所有
     *
     * @return {@link List}<{@link User}>
     */
     @Select(value = "select * from `user3`")
    public List<User> findAll();



}
