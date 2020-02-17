package com.zhiqiangw.canteen.mapper;
import com.zhiqiangw.canteen.bean.FoodStore;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IFoodStoreDao {
    /**
     * 查询库房中所有的菜
     * @return
     */
    @Select("select * from food")
    List<FoodStore> findAll();

    /**
     * 查询行数
     * @return
     */
    @Select("select count(1) from food")
    int count();

    /**
     * 更新foodid对应的数量
     * @param foodid
     * @param foodamount
     */
    @Update("update food set foodamount=#{foodamount} where foodid=#{foodid}")
    void updateNumById(@Param("foodid") int foodid, @Param("foodamount") String foodamount);

    /**
     * 根据id找对应的行
     * @param foodid
     * @return
     */
    @Select("select * from food where foodid=#{foodid}")
    FoodStore findOneById(int foodid);


    @Select("select * from food where foodname=#{foodname}")
    FoodStore findOneByname(String foodname);

    @Update("update food set foodamount=#{foodamount} where foodname=#{foodname}")
    void updateNumByName(@Param("foodname") String foodname, @Param("foodamount") String foodamount);

    @Insert("insert into food(foodname,foodamount,alarmamount,money,changenum,lowalarmamount)values(#{foodname},#{foodamount},#{alarmamount},#{money},#{changenum},#{lowalarmamount})")
    void insertOne(FoodStore foodStore);
}
