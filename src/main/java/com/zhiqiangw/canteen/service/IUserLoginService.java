package com.zhiqiangw.canteen.service;



import com.zhiqiangw.canteen.bean.UserLogin;

import java.util.List;

public interface IUserLoginService {
    //管理端操作
    /**
     * 查询所有账户信息，管理端查询
     * @return
     */
    List<UserLogin> findAll();
    /**
     * 删除指定id的账号，管理端可操作
     * @param id
     */
    void deletById(int id);

    /**
     * 插入用户登陆记录
     * @param userLogin
     */

    void insertOne(UserLogin userLogin);

    //所有端都可以操作
    /**
     * 根据账号查找用户信息
     * @param account 用户账号
     * @return
     */
    UserLogin findByAccount(String account);

    /**
     * 修改登陆信息
     * @param userLogin
     */
    void updateByAccount(UserLogin userLogin);

    void providerLogin(UserLogin userLogin);

    /* *
     * @Description: 判断用户是否可以登录，是返回true，不可以返回false
     * @Author zhiqiangw
     * @Date 2020/2/14 15:53
     * @param: username
     * @param: password
     * @return: boolean
     */
    boolean canLogin(String account,String password);

}
