package com.zhiqiangw.canteen.mapper;


import com.zhiqiangw.canteen.bean.AskedFood;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAskedFoodDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from askedfood")
    List<AskedFood> findAll();

    /**
     * 根据状态查询订单
     * @return
     */
    @Select("select * from askedfood where status=#{status}")
    List<AskedFood>findByStatus(String status);

    @Insert("insert into askedfood(foodname,askedamount,finishtime,status)values(#{foodname},#{askedamount},#{finishtime},#{status})")
    void insertOne(AskedFood askedFood);

    @Update("update askedfood set ordernumber=#{ordernumber},status=#{status} where fooduid=#{fooduid}")
    void updateById(@Param("fooduid") int fooduid, @Param("ordernumber") int ordernumber, @Param("status") String status);

    @Select("select * from askedfood where ordernumber=#{ordernumber}")
    List<AskedFood> findByOrdernumber(int ordernumber);
}