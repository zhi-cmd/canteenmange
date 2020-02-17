package com.zhiqiangw.canteen.mapper;


import com.zhiqiangw.canteen.bean.HistoryUse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//交给IOC容器
@Mapper
public interface IHistoryUseDao {

    /**
     * 插入一条数据
     */
    @Insert("insert into historyuse(foodid,time,usenumber)values(#{foodid},#{time},#{usenumber})")
    void insertOne(HistoryUse historyUse);

    /**
     * 查询本周的数据
     * @param foodid
     * @return
     */
    @Select("SELECT * FROM historyuse where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(time) and foodid=#{foodid}")
    List<HistoryUse> find7DaysByID(int foodid);

    /**
     * 查询进30天的数据
     * @param foodid
     * @return
     */
    @Select("SELECT * FROM historyuse where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(time) and foodid=#{foodid}")
    List<HistoryUse> find30DaysByID(int foodid);

    /**
     * 查找本季度的数据
     * @param foodid
     * @return
     */
    @Select("select * from historyuse where QUARTER(time)=QUARTER(now()) and foodid=#{foodid}")
    List<HistoryUse> findAllDaysByID(int foodid);

    /**
     * 查找近一年的数据
     * @param foodid
     * @return
     */
    @Select("select * from historyuse where YEAR(time)=YEAR(NOW()) and foodid=#{foodid}")
    List<HistoryUse> findYearsByID(int foodid);
}
