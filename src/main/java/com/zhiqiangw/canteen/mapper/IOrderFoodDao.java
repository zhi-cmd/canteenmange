package com.zhiqiangw.canteen.mapper;

import com.zhiqiangw.canteen.bean.OrderFood;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface IOrderFoodDao {

    /**
     *查询所有
     * @return
     */
    @Select("select * from orderfood")
    List<OrderFood> findAll();


    /**
     * 根据状态查询订单
     * @param status
     * @return
     */
    @Select("select * from orderfood where status=#{status}")
    List<OrderFood> findByStatus(String status);


    /**
     * 查询行数
     * @return
     */
    @Select("select count(1) from orderfood")
    int count();

    /**
     * @Description: 查询指定状态的数据条数
     * @Author zhiqiangw
     * @Date 2020/2/17 11:33
     * @param: status
     * @return: int
     */
    @Select("select count(1) from orderfood where status=#{status}")
    int countByStatus(String status);

    /**
     * 插入一跳数据
     * @param orderFood
     */
    @Insert("insert into orderfood (ordernumber,provideraccount,totalmoney,status,ordertime)VALUES(#{ordernumber},#{provideraccount},#{totalmoney},#{status},#{ordertime})")
    void insertOne(OrderFood orderFood);

    /**
     * 更新订单的状态
     * @param ordernumber
     * @param status
     */
    @Update("update orderfood set status=#{status} where ordernumber=#{ordernumber}")
    void updateStautsByordernum(@Param("ordernumber") int ordernumber, @Param("status") String status);

    /**
     * 更新订单的供应者
     */
    @Update("update orderfood set provideraccount=#{provideraccount} where ordernumber=#{ordernumber} ")
    void updateProviderByordernum(@Param("ordernumber") int ordernumber, @Param("provideraccount") String provideraccount);

    /**
     * 更新整个订单行
     * @param orderFood
     */
    @Update("update orderfood set provideraccount=#{provideraccount},status=#{status},ordertime=#{ordertime} where ordernumber=#{ordernumber}")
    void updateOne(OrderFood orderFood);

    @Delete("delete from orderfood where ordernumber =#{ordernumber}")
    void deleteByOrdernum(Integer ordernumber);

    @Select("select * from orderfood where ordernumber =#{ordernumber}")
    OrderFood findByNum(Integer ordernumber);

    /**
     * @Description: 获取订单号的最大值，用于自动生成订单
     * @Author zhiqiangw
     * @Date 2020/2/17 12:30
     * @return: int
     */
    @Select("select max(ordernumber) from orderfood")
    int findMaxOrderNumber();

}