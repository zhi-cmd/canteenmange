package com.zhiqiangw.canteen.mapper;

import com.zhiqiangw.canteen.bean.ReceivedFood;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface IReveivedFoodDao {

    @Insert("insert into receivedfood (ordernumber,foodname,trueamount,finishtime)values(#{ordernumber},#{foodname},#{trueamount},#{finishtime})")
    void insertOne(ReceivedFood receivedFood);

    @Select("select * from receivedfood")
    List<ReceivedFood> findAll();

    @Select("select * from received where ordernumber=#{ordernumber}")
    List<ReceivedFood> findByOrdernumber(int ordernumber);
}
