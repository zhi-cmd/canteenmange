package com.zhiqiangw.canteen.mapper;

import com.zhiqiangw.canteen.bean.ProviderMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IProviderMsgDao {

    @Select("select * from providermsg")
    List<ProviderMsg> findAll();

    /**
     * 根据供应商状态查找供应商
     * @param status
     * @return
     */
    @Select("select * from providermsg where status=#{status}")
    List<ProviderMsg> findByStatus(String status);

    /**
     *
     * @param providerMsg
     */
    @Insert("insert into providermsg (providernum,shopname,connect,shopmsg,location,license,status) VALUES(#{providernum},#{shopname},#{connect},#{shopmsg},#{location},#{license},#{status})")
    void insertOne(ProviderMsg providerMsg);

    /**
     * 更新供应商信息
     * @param providerMsg
     */
    @Update("update providermsg set shopname=#{shopname},connect=#{connect},shopmsg=#{shopmsg},location=#{location},license=#{license},status=#{status} where providernum=#{providernum}")
    void updateByProviderNum(ProviderMsg providerMsg);

    /**
     * 更新供应商的状态
     * @param providerMsg
     */
    @Update("update providermsg set status=#{status} where providernum=#{providernum}")
    void updateStatusByProviderNum(ProviderMsg providerMsg);

    @Select("select status from providermsg where providernum=#{providernumber}")
    String getStatusByNum(String providernumber);

    @Select("select * from providermsg where providernum=#{providernumber}")
    ProviderMsg findByProviderNum(String providernumber);


}
