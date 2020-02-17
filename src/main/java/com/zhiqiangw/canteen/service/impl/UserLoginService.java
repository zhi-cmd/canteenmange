package com.zhiqiangw.canteen.service.impl;

import com.zhiqiangw.canteen.bean.ProviderMsg;
import com.zhiqiangw.canteen.bean.UserLogin;
import com.zhiqiangw.canteen.mapper.IProviderMsgDao;
import com.zhiqiangw.canteen.mapper.IUserLoginDao;
import com.zhiqiangw.canteen.service.IUserLoginService;

import com.zhiqiangw.canteen.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserLoginService")
public class UserLoginService implements IUserLoginService {
    //自动注入
    @Autowired
    private IUserLoginDao userLoginDao;

    @Autowired
    private IProviderMsgDao providerMsgDao;
    public List<UserLogin> findAll() {
        //System.out.println("业务层查询所有");
        return userLoginDao.findAll();
    }

    public void deletById(int id) {
        userLoginDao.deletById(id);
    }

    public void insertOne(UserLogin userLogin) {
        //进行MD5加密处理
        String MD5Password= MyUtils.getMD5String(userLogin.getPassword());
        userLogin.setPassword(MD5Password);
        userLoginDao.insertOne(userLogin);;
    }

    public UserLogin findByAccount(String account) {
        return userLoginDao.findByAccount(account);
    }

    public void updateByAccount(UserLogin userLogin) {

    }

    @Override
    public void providerLogin(UserLogin userLogin) {
        userLogin.setIdentity("3");
        userLoginDao.insertOne(userLogin);
        ProviderMsg providerMsg =new ProviderMsg();
        providerMsg.setStatus("0");
        providerMsg.setProvidernum(userLogin.getAccount());
        providerMsgDao.insertOne(providerMsg);
    }
    /* *
     * @Description: 判断用户是否可以登录，是返回true，不可以返回false
     * @Author zhiqiangw
     * @Date 2020/2/14 15:53
     * @param: username
     * @param: password
     * @return: boolean
     */
    @Override
    public boolean canLogin(String account, String password) {
        UserLogin user= userLoginDao.findByAccount(account);
        return false;
    }

}
