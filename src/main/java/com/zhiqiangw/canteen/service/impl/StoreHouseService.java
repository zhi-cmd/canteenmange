package com.zhiqiangw.canteen.service.impl;

import com.zhiqiangw.canteen.bean.FoodStore;
import com.zhiqiangw.canteen.bean.HistoryBuy;
import com.zhiqiangw.canteen.bean.HistoryUse;
import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.mapper.IFoodStoreDao;
import com.zhiqiangw.canteen.mapper.IHistoryBuyDao;
import com.zhiqiangw.canteen.mapper.IHistoryUseDao;
import com.zhiqiangw.canteen.mapper.IOrderFoodDao;
import com.zhiqiangw.canteen.service.IStoreHouseSrevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("StoreHouseService")
public class StoreHouseService implements IStoreHouseSrevice {
    //自动注入
    @Autowired
    //private IUserLoginDao userLoginDao;
    private IFoodStoreDao foodStoreDao;

    //自动注入
    @Autowired
    private IHistoryBuyDao historyBuyDao;

    //自动注入
    @Autowired
    private IHistoryUseDao historyUseDao;

    @Autowired
    private IOrderFoodDao orderFoodDao;

    @Autowired
    private StoreHouseService storeHouseService;
    Logger logger = LoggerFactory.getLogger(getClass());

    public List<FoodStore> showAllStoreHouse() {
        return foodStoreDao.findAll();
    }

    /**
     * 根据修改量更改仓库里的值
     * @param foodid
     * @param foodamoun 修改量
     */
    public void updateUseNum(int foodid, int foodamoun) {
        FoodStore foodStore =foodStoreDao.findOneById(foodid);
        int lastnum = Integer.parseInt(foodStore.getFoodamount());
        System.out.println(lastnum);
        System.out.println(foodamoun);
        String foodamount = String.valueOf(lastnum-foodamoun);
        System.out.println(foodamount);
        foodStoreDao.updateNumById(foodid,foodamount);

    }
/**
 * @Description: 获取所有的在报警状态的食品
 * @Author zhiqiangw
 * @Date 2020/2/15 19:11
 * @return: java.util.List<com.zhiqiangw.canteen.bean.FoodStore>
 */
    public List<FoodStore> findAllAlarm() {
        List<FoodStore> foodStores = foodStoreDao.findAll();

        Iterator<FoodStore> iterator = foodStores.iterator();
        while (iterator.hasNext()) {
            FoodStore foodStore = iterator.next();
            if((Integer.parseInt(foodStore.getFoodamount())<Integer.parseInt(foodStore.getAlarmamount()))&&(Integer.parseInt(foodStore.getFoodamount())>Integer.parseInt(foodStore.getLowalarmamount()))){
                //报处于正常情况下的食品剔除
                iterator.remove();
            }
        }

        return foodStores;//返回所有处于报警状态的食品
    }

    public void insertHistoryUse(HistoryUse historyUse) {
        historyUseDao.insertOne(historyUse);
    }

    public void insertHistoryBuy(HistoryBuy historyBuy) {
        historyBuyDao.insertOne(historyBuy);
    }

    public FoodStore findOneById(int foodid) {
        return foodStoreDao.findOneById(foodid);
    }

    public FoodStore findOneByName(String foodname) {
        return foodStoreDao.findOneByname(foodname);
    }

    public List<HistoryBuy> findHistoryBuy7Day(int foodid) {
        return historyBuyDao.find7DaysByID(foodid);
    }

    public List<HistoryBuy> findHistoryBuy30Day(int foodid) {
        return historyBuyDao.find30DaysByID(foodid);
    }

    public List<HistoryBuy> findHistoryBuy1Ji(int foodid) {
        return historyBuyDao.findAllDaysByID(foodid);
    }

    public List<HistoryBuy> findHistoryBuy1Year(int foodid) {
        return historyBuyDao.findYearsByID(foodid);
    }

    public List<HistoryUse> findHistoryUse7Day(int foodid) {
        return historyUseDao.find7DaysByID(foodid);
    }

    public List<HistoryUse> findHistoryUse30Day(int foodid) {
        return historyUseDao.find30DaysByID(foodid);
    }

    public List<HistoryUse> findHistoryUse1Ji(int foodid) {
        return historyUseDao.findAllDaysByID(foodid);
    }

    public List<HistoryUse> findHistoryUse1Year(int foodid) {
        return historyUseDao.findYearsByID(foodid);
    }

    @Override
    public List<OrderFood> findReceivedOrder() {
        return orderFoodDao.findByStatus("2");
    }

    @Override
    public List<OrderFood> findRejectedOrder() {
            return orderFoodDao.findByStatus("4");
    }


    @Override
    public void putInStore(Map<String, Integer> map) {
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            foodStoreDao.updateNumByName(entry.getKey(),String.valueOf(entry.getValue()+Integer.parseInt(foodStoreDao.findOneByname(entry.getKey()).getFoodamount())));
        }
    }

    /**
     * @Description: 修改订单状态
     * @Author zhiqiangw
     * @Date 2020/2/16 11:45
     * @param: ordernumber 订单号
     * @param: status 订单状态代号 0->待处理，1->待发货，2->已经发货，3->确认收货，4->拒绝收货
     */
    @Override
    public void changeOrderStatus(int ordernumber,String status) {
        orderFoodDao.updateStautsByordernum(ordernumber,status);
    }

    /**
     * @Description: 查询带显示的图表的数据
     * @Author zhiqiangw
     * @Date 2020/2/15 18:14
     * @param: foodid
     * @param: type
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @Override
    public Map<String, Object> getFoodStoreChartData(Integer foodid, String type) {
        Map<String,Object> map = new HashMap<>();
        List<HistoryUse> historyUses;
        if(type.equals("UWeek")) {
            historyUses = storeHouseService.findHistoryUse7Day(foodid);
        }
        else if(type.equals("UMonth")){
            historyUses =storeHouseService.findHistoryUse30Day(foodid);
        }
        else if(type.equals("UJidu")){
            historyUses=storeHouseService.findHistoryUse1Ji(foodid);
        }
        else {
            historyUses=storeHouseService.findHistoryUse1Year(foodid);
        }
        //System.out.println("dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        ArrayList<String> yData =new ArrayList<>();
        ArrayList<String> xData=new ArrayList<>();
        if (!historyUses.isEmpty()) {
            for (HistoryUse historyUse : historyUses) {
                yData.add(String.valueOf(historyUse.getUsenumber()));
                xData.add(String.valueOf(historyUse.getTime()));
            }
        }
        map.put("xData",xData);
        map.put("yData",yData);
        return map;
    }

    /**
     * @Description: 向食品仓库中添加一个食品，先判断是否有该菜品，没有再进行添加
     * @Author zhiqiangw
     * @Date 2020/2/17 13:27
     * @param: foodStore 菜品对象
     * @return: boolean
     */
    @Override
    public boolean addOneFood(FoodStore foodStore) {
        if(foodStoreDao.findOneByname(foodStore.getFoodname())==null){//该食品未被添加
            foodStore.setChangenum(0);
            foodStoreDao.insertOne(foodStore);
            return true;
        }
        else return false;
    }

}
