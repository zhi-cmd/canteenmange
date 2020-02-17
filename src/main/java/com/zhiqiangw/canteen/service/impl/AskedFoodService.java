package com.zhiqiangw.canteen.service.impl;


import com.zhiqiangw.canteen.bean.AskedFood;
import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.mapper.IAskedFoodDao;
import com.zhiqiangw.canteen.mapper.IFoodStoreDao;
import com.zhiqiangw.canteen.mapper.IOrderFoodDao;
import com.zhiqiangw.canteen.service.IAskedFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AskedFoodService")
public class AskedFoodService implements IAskedFoodService {
    @Autowired
    private IAskedFoodDao askedFoodDao;
    @Autowired
    private IOrderFoodDao orderFoodDao;
    @Autowired
    private IFoodStoreDao foodStoreDao;
    @Autowired
    private AskedFoodService askedFoodService;
    public List<AskedFood> findAllAsked() {
        return askedFoodDao.findAll();
        //return null;
    }

    public List<AskedFood> findNotDeal() {
        //return null;
        return askedFoodDao.findByStatus("0");
    }

    public void insertOneAsked(AskedFood askedFood) {
        askedFoodDao.insertOne(askedFood);
    }

    @Override
    public int getNextOrderNum() {
        return orderFoodDao.findMaxOrderNumber()+1;
    }


    public void addOrder(OrderFood orderFood) {
        orderFoodDao.insertOne(orderFood);
    }

    public void makeupAskedFood(int fooduid, int ordernumber) {
        askedFoodDao.updateById(fooduid,ordernumber,"1");
    }

    public String getMoneyByname(String foodname) {
        return foodStoreDao.findOneByname(foodname).getMoney();
    }

    public List<OrderFood> findAllOrder() {
        return orderFoodDao.findAll();
    }

    public void setOrderStatusTo1(int ordernumber) {
        orderFoodDao.updateStautsByordernum(ordernumber,"1");
    }

    public void setOrderStatusTo2(int ordernumber) {
        orderFoodDao.updateStautsByordernum(ordernumber,"2");
    }

    public void setProvideraccount(int ordernumber, String provideraccount) {
        orderFoodDao.updateProviderByordernum(ordernumber,provideraccount);
    }

    public List<OrderFood> findNotDealOrder() {
        return orderFoodDao.findByStatus("0");
    }

    @Override
    public List<OrderFood> findProviderShow() {
        return orderFoodDao.findByStatus("1");
    }

    @Override
    public List<AskedFood> findOrderDetail(int ordernumber) {
        return askedFoodDao.findByOrdernumber(ordernumber);
    }

    /**
     * @Description: 将同一个订单中相同的食品的数量求和
     * @Author zhiqiangw
     * @Date 2020/2/16 11:41
     * @param: askedFoods
     * @return: java.util.Map<java.lang.String,java.lang.Integer>
     */
    @Override
    public Map<String, Integer> getNumberByFoodName(List<AskedFood> askedFoods) {
        Map<String,Integer> map=new HashMap<>();
        for (AskedFood askedFood:askedFoods){
            String foodName = askedFood.getFoodname();
            int num=Integer.parseInt(askedFood.getAskedamount());
            if(map.containsKey(foodName)){
                map.put(foodName,map.get(foodName)+num);
            }
            else {
                map.put(foodName,num);
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> getOrderChartData(Integer ordernumber) {
        Map<String,Object> map = new HashMap<>();
        //获取该订单的所有信息
        List<AskedFood> askedFoods=askedFoodService.findOrderDetail(ordernumber);
        ArrayList<String> yData =new ArrayList<>();
        ArrayList<String> xData=new ArrayList<>();
        //将订单中同样的菜品数量相加
        Map<String,Integer> map1 = askedFoodService.getNumberByFoodName(askedFoods);
        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            xData.add(entry.getKey());
            yData.add(String.valueOf(entry.getValue()));
        }
        map.put("xData",xData);
        map.put("yData",yData);
        return map;
    }

    /**
     * @Description: 取消订单，修改请求购物状态为0，代表未处理
     * @Author zhiqiangw
     * @Date 2020/2/16 16:45
     * @param: fooduid
     * @param: status 1-已经生成订单，0-未生成订单
     */
    @Override
    public void setAskedStatusTo0(Integer fooduid){
        askedFoodDao.updateById(fooduid,0,"0");
    }

    @Override
    public void deleteOrderByNum(Integer ordernumber) {
        orderFoodDao.deleteByOrdernum(ordernumber);
    }

    @Override
    public OrderFood findOrderByNum(Integer ordernumber) {
        return orderFoodDao.findByNum(ordernumber);
    }

}
