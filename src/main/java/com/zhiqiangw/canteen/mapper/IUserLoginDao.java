package com.zhiqiangw.canteen.mapper;

import com.zhiqiangw.canteen.bean.UserLogin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户登陆的功能查询，修改密码，注册功能
 */
//交给IOC容器
@Mapper
public interface IUserLoginDao {
    //管理端操作
    /**
     * 查询所有账户信息，管理端查询
     * @return
     */
    @Select("select * from user")
     List<UserLogin> findAll();

    /**
     * 查询行数
     * @return
     */
    @Select("select count(1) from user")
    int count();
    /**
     * 删除指定id的账号，管理端可操作
     * @param id
     */
    @Delete("delete  from user where id=#{id}")
    void deletById(int id);

    /**
     * 插入用户登陆记录
     * @param userLogin
     */
    @Insert("insert into user (account,username,password,identity)VALUES (#{account},#{username},#{password},#{identity})")
    void insertOne(UserLogin userLogin);

    //所有端都可以操作
    /**
     * 根据账号查找用户信息
     * @param account 用户账号
     * @return
     */
    @Select("select * from user where account=#{account}")
    UserLogin findByAccount(String account);

    /**
     * 修改登陆信息
     * @param userLogin
     */
    void updateByAccount(UserLogin userLogin);

}
