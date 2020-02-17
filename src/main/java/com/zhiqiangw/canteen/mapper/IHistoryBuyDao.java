package com.zhiqiangw.canteen.mapper;

import com.zhiqiangw.canteen.bean.HistoryBuy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IHistoryBuyDao {

    /**
     * 插入一条数据
     */
    @Insert("insert into historybuy(foodid,time,buynumber)values(#{foodid},#{time},#{buynumber})")
    void insertOne(HistoryBuy historyBuy);

    /**
     * 查询本周的数据
     * @param foodid
     * @return
     */
    @Select("SELECT * FROM historybuy where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(time) and foodid=#{foodid}")
    List<HistoryBuy> find7DaysByID(int foodid);

    /**
     * 查询进30天的数据
     * @param foodid
     * @return
     */
    @Select("SELECT * FROM historybuy where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(time) and foodid=#{foodid}")
    List<HistoryBuy> find30DaysByID(int foodid);

    /**
     * 查找本季度的数据
     * @param foodid
     * @return
     */
    @Select("select * from historybuy where QUARTER(time)=QUARTER(now()) and foodid=#{foodid}")
    List<HistoryBuy> findAllDaysByID(int foodid);

    /**
     * 查找近一年的数据
     * @param foodid
     * @return
     */
    @Select("select * from historybuy where YEAR(time)=YEAR(NOW()) and foodid=#{foodid}")
    List<HistoryBuy> findYearsByID(int foodid);
}
