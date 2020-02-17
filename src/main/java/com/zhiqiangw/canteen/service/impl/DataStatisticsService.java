package com.zhiqiangw.canteen.service.impl;

import com.zhiqiangw.canteen.bean.FoodStore;
import com.zhiqiangw.canteen.dto.WelcomeDataStatistics;
import com.zhiqiangw.canteen.mapper.IFoodStoreDao;
import com.zhiqiangw.canteen.mapper.IOrderFoodDao;
import com.zhiqiangw.canteen.mapper.IUserLoginDao;
import com.zhiqiangw.canteen.service.IDataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DataStatisticsService
 * @Description
 * @Author zhiqiangw
 * @DATA 2020-2-17 11:21
 * @Version 1.0
 **/
@Service("DataStatisticsService")
public class DataStatisticsService implements IDataStatisticsService {
    @Autowired
    private IOrderFoodDao iOrderFoodDao;
    @Autowired
    private IFoodStoreDao iFoodStoreDao;
    @Autowired
    private IUserLoginDao iUserLoginDao;

    /**
     * @Description: 获取一个weclom界面数据统计需要的对象
     * @Author zhiqiangw
     * @Date 2020/2/17 11:24
     * @return: com.zhiqiangw.canteen.dto.WelcomeDataStatistics
     */
    @Override
    public WelcomeDataStatistics getWelcomeDataStatistics() {
        WelcomeDataStatistics welcomeDataStatistics = new WelcomeDataStatistics();
        //订单总数
        welcomeDataStatistics.setTotalOrder(iOrderFoodDao.count());
        //完成订单数
        welcomeDataStatistics.setCompleteOrder(iOrderFoodDao.countByStatus("2"));
        //食品仓库食品总种类
        welcomeDataStatistics.setTotalFood(iFoodStoreDao.count());
        //系统用户总数
        welcomeDataStatistics.setTotalUsers(iUserLoginDao.count());
        //统计上下限报警的数
        List<FoodStore> foodStores = iFoodStoreDao.findAll();//食品仓库的所有
        int countLow=0;
        int countHigh=0;
        for(FoodStore foodStore:foodStores){
            //统计报警个数
            if(Integer.parseInt(foodStore.getFoodamount())<Integer.parseInt(foodStore.getLowalarmamount())){//下限报警
                countLow++;
            }
            else if(Integer.parseInt(foodStore.getFoodamount())>Integer.parseInt(foodStore.getAlarmamount())){//上限报警
                countHigh++;
            }
        }
        welcomeDataStatistics.setHighAlarm(countHigh);
        welcomeDataStatistics.setLowAlarm(countLow);
        return welcomeDataStatistics;
    }
}
