package com.zhiqiangw.canteen.service.impl;

import com.zhiqiangw.canteen.bean.AskedFood;
import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.bean.ProviderMsg;
import com.zhiqiangw.canteen.bean.ReceivedFood;

import com.zhiqiangw.canteen.mapper.*;
import com.zhiqiangw.canteen.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("ProviderService")
public class ProviderService implements IProviderService {
    //自动注入
    @Autowired
    //private IUserLoginDao userLoginDao;
    private IFoodStoreDao foodStoreDao;

    @Autowired
    private IProviderMsgDao providerMsgDao;

    @Autowired
    private IOrderFoodDao orderFoodDao;

    @Autowired
    private IAskedFoodDao askedFoodDao;
    @Autowired
    private IReveivedFoodDao reveivedFoodDao;

    @Autowired
    private IUserLoginDao userLoginDao;


    private BaseService baseService;
    @Override
    public void updateProviderMsg(ProviderMsg providerMsg) {
        providerMsgDao.updateByProviderNum(providerMsg);
    }

    @Override
    public List<ProviderMsg> findAllProvider() {
        return providerMsgDao.findAll();
    }

    @Override
    public List<ProviderMsg> findNotIdentifyProvider() {
        return providerMsgDao.findByStatus("0");
    }

    @Override
    public void identifyProvider(String providernum) {
        ProviderMsg providerMsg =new ProviderMsg();
        providerMsg.setProvidernum(providernum);
        providerMsg.setStatus("1");
        providerMsgDao.updateStatusByProviderNum(providerMsg);
    }

    @Override
    public void ignoreProvider(String providenumber){
        ProviderMsg providerMsg =new ProviderMsg();
        providerMsg.setProvidernum(providenumber);
        providerMsg.setStatus("2");//2状态是被忽略的供应商
        //更新整条供应商记录
        providerMsgDao.updateStatusByProviderNum(providerMsg);
    }

    @Override
    public List<OrderFood> findNotDealOrder() {
        return orderFoodDao.findByStatus("1");
    }

    @Override
    public boolean confirmProvider(Integer ordernumber,String providernum) {
        OrderFood orderFood =new OrderFood();
        orderFood.setOrdernumber(ordernumber);
        orderFood.setTotalmoney(orderFoodDao.findByNum(ordernumber).getTotalmoney());//获取订单总金额
        if(isHasPower(providernum)) {//判断供应商是否被认证
            //更新信息
            orderFood.setStatus("2");
            Timestamp time1 = new Timestamp(System.currentTimeMillis());
            orderFood.setOrdertime(time1);
            orderFood.setProvideraccount(providernum);
            orderFoodDao.updateOne(orderFood);
            //更新aksed表
            List<AskedFood> askedFoods = askedFoodDao.findByOrdernumber(orderFood.getOrdernumber());
            int orderNumber = orderFood.getOrdernumber();
            for (AskedFood askedFood : askedFoods) {
                ReceivedFood receivedFood = new ReceivedFood();
                receivedFood.setFoodname(askedFood.getFoodname());
                receivedFood.setFinishtime(time1);
                receivedFood.setOrdernumber(orderNumber);
                receivedFood.setTrueamount(askedFood.getAskedamount());
                reveivedFoodDao.insertOne(receivedFood);
            }
            return true;
        }
        else return false;//权限不足
    }

    @Override
    public boolean isHasPower(String providernum) {
        return providerMsgDao.getStatusByNum(providernum).equals("1");//已确认状态
    }

    /**
     * @Description: 根据供应商账号查询供应商信息
     * @Author zhiqiangw
     * @Date 2020/2/16 20:36
     * @param: providernum
     * @return: com.zhiqiangw.canteen.bean.ProviderMsg
     */
    @Override
    public ProviderMsg findProviderMsgByNum(String providernum) {
        return providerMsgDao.findByProviderNum(providernum);
    }

//    @Override
//    public boolean isHasPower(UserLogin userLogin) {
//        if(userLogin.getIdentity().equals("3")){
//            if (providerMsgDao.getStatusByNum(userLogin.getAccount()).equals("1"))return true;
//            else return false;
//        }
//        else {
//            return false;
//        }
//    }
}
