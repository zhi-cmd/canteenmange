package com.zhiqiangw.canteen.service;



import com.zhiqiangw.canteen.bean.FoodStore;
import com.zhiqiangw.canteen.bean.HistoryBuy;
import com.zhiqiangw.canteen.bean.HistoryUse;
import com.zhiqiangw.canteen.bean.OrderFood;

import java.util.List;
import java.util.Map;

public interface IStoreHouseSrevice {
    /**
     * 所有库存信息查看
     * @return
     */
    List<FoodStore> showAllStoreHouse();

    /**
     * 使用后修改对应的值
     */
    void updateUseNum(int foodid, int foodamoun);


    List<FoodStore> findAllAlarm();

    /**
     * 插入使用历史记录
     * @param historyUse
     */
    void insertHistoryUse(HistoryUse historyUse);

    /**
     * 插入购买历史记录
     * @param historyBuy
     */
    void insertHistoryBuy(HistoryBuy historyBuy);

    FoodStore findOneById(int foodid);

    FoodStore findOneByName(String foodname);


    List<HistoryBuy> findHistoryBuy7Day(int foodid);

    List<HistoryBuy> findHistoryBuy30Day(int foodid);

    List<HistoryBuy> findHistoryBuy1Ji(int foodid);

    List<HistoryBuy> findHistoryBuy1Year(int foodid);

    List<HistoryUse> findHistoryUse7Day(int foodid);

    List<HistoryUse> findHistoryUse30Day(int foodid);

    List<HistoryUse> findHistoryUse1Ji(int foodid);

    List<HistoryUse> findHistoryUse1Year(int foodid);

    /**
     * 寻找已经发货的订单
     * @return
     */
    List<OrderFood> findReceivedOrder();

    /**
     * @Description: 寻找被拒绝的订单
     * @Author zhiqiangw
     * @Date 2020/2/16 12:20
     * @return: java.util.List<com.zhiqiangw.canteen.bean.OrderFood>
     */
    List<OrderFood> findRejectedOrder();

    /**
     * 入库操作
     * @param map
     */
    void putInStore(Map<String, Integer> map);


    /**
     * @Description: 更新订单状态
     * @Author zhiqiangw
     * @Date 2020/2/16 11:44
     * @param: ordernumber
     * @param: status 订单状态代号
     */
    void changeOrderStatus(int ordernumber,String status);

    /**
     * @Description: 获取菜品仓库表格要显示的数据
     * @Author zhiqiangw
     * @Date 2020/2/15 18:09
     * @param: foodid 菜品编号
     * @param: type  要显示的表的种类
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     *     xData:list，时间列表
     *     yData:list，使用量列表
     */
    Map<String,Object> getFoodStoreChartData(Integer foodid,String type);

    /**
     * @Description: 向食品仓库中添加一种菜品，先判读是否存在
     * @Author zhiqiangw
     * @Date 2020/2/17 13:19
     * @param: foodStore
     * @return: boolean true添加成功，false添加失败，已经存在
     */
    boolean addOneFood(FoodStore foodStore);

}
