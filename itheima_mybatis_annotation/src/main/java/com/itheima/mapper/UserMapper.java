package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.*;

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


    // 先将所有的用户查询出来, 然后再去引用用户中待查的其他数据(订单). 执行步骤: 遍历内查询方式
    @Select("select * from `user3`")
    @Results({
            // 标名查询到的id这个结果列是主键列
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "orderList",     // 待封装的成员变量名称
                    column = "id",              // 实际上这个是外键
                    // 注意这个一对多查询出来的是List类型. 因此传入的是List的字节码
                    javaType = List.class,
                    // 引用OrderMapper中的findByUid方法查询对应用户的订单信息. 根据column参数查询.
                    many = @Many(select = "com.itheima.mapper.OrderMapper.findByUid")
            )
        }
    )
    public List<User> findUserAndOrderAll();


}
