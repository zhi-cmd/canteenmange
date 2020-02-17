package com.zhiqiangw.canteen.service;



import com.zhiqiangw.canteen.bean.AskedFood;
import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.bean.ProviderMsg;

import java.util.List;
import java.util.Map;

public interface IAskedFoodService {
    /**
     * 所有请求订单
     * @return
     */
    List<AskedFood> findAllAsked();

    /**
     * 所有未处理的订单请求
     * @return
     */
    List<AskedFood> findNotDeal();

    /**
     * 插入一跳请求
     */
    void insertOneAsked(AskedFood askedFood);

    /**
     * 获取下一个订单的订单号
     * @return
     */
    int getNextOrderNum();

    /**
     * 插入一条订单信息
     * @param orderFood
     */
    void addOrder(OrderFood orderFood);

    void makeupAskedFood(int fooduid, int ordernumber);

    String getMoneyByname(String foodname);

    /**
     * 查询所有订单
     * @return
     */
    public List<OrderFood> findAllOrder();

    /**
     * 修改订单状态为状态1，以确认
     * @param ordernumber
     */
    void setOrderStatusTo1(int ordernumber);

    /**
     * 修改订单状态为2，已经供货
     * @param ordernumber
     */
    void setOrderStatusTo2(int ordernumber);


    /**
     * 为订单添加供货商
     * @param ordernumber
     * @param provideraccount
     */
    void setProvideraccount(int ordernumber, String provideraccount);

    List<OrderFood> findNotDealOrder();

    List<OrderFood> findProviderShow();

    List<AskedFood> findOrderDetail(int ordernumber);

    /**
     * 计算list中每种菜的总数，有可能有重复就加起来
     * @param askedFoods
     * @return
     */
    Map<String,Integer> getNumberByFoodName(List<AskedFood> askedFoods);

    /**
     * @Description: 获取订单详情的图表数据
     * @Author zhiqiangw
     * @Date 2020/2/16 10:49
     * @param: ordernumber
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getOrderChartData(Integer ordernumber);

    /**
     * @Description: 修改购物请求的状态，设置预购状态为0，取消订单执行的操作
     * @Author zhiqiangw
     * @Date 2020/2/16 16:45
     * @param: fooduid
     * @param: status 1-已经生成订单，0-未生成订单
     */
    void setAskedStatusTo0(Integer fooduid);

    /**
     * @Description: 根据订单号删除订单
     * @Author zhiqiangw
     * @Date 2020/2/16 17:04
     * @param: ordernumber 订单号
     */
    void deleteOrderByNum(Integer ordernumber);

    /**
     * @Description: 根据订单号查询订单
     * @Author zhiqiangw
     * @Date 2020/2/16 20:33
     * @param: ordernumber
     * @return: com.zhiqiangw.canteen.bean.OrderFood
     */
    OrderFood findOrderByNum(Integer ordernumber);

}
