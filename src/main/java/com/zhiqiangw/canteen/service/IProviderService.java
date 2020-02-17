package com.zhiqiangw.canteen.service;

import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.bean.ProviderMsg;

import java.util.List;

public interface IProviderService {
    /**
     * 更新供应商信息
     * @param providerMsg
     */
    void updateProviderMsg(ProviderMsg providerMsg);

    /**
     * 查看所有的供应商
     * @return
     */
    List<ProviderMsg> findAllProvider();

    /**
     * 查看所有未被认证的供应商
     * @return
     */
    List<ProviderMsg> findNotIdentifyProvider();

    /**
     * 认证指定的供应商
     * @param providernum
     * @return
     */
    void identifyProvider(String providernum);

    /**
     * @Description: 忽略某个供应商认证请求
     * @Author zhiqiangw
     * @Date 2020/2/16 20:08
     * @param: providenumber
     */
    void ignoreProvider(String providenumber);

    /**
     * 查询可以处理的订单
     * @return
     */
    List<OrderFood> findNotDealOrder();

    /**
     * 确认提供订单，修改订单状态，修改订单对应的库存量
     * @param
     */
    boolean confirmProvider(Integer ordernumber, String providernum);

    /**
     * 判断供应商是否又权限
     * @return
     */
    boolean isHasPower(String providernum);


    /**
     * @Description: 根据供应商账号查询供应商
     * @Author zhiqiangw
     * @Date 2020/2/16 20:34
     * @param: providernum
     * @return: com.zhiqiangw.canteen.bean.ProviderMsg
     */
    ProviderMsg findProviderMsgByNum(String providernum);


}
