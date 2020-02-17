package com.zhiqiangw.canteen.service.impl;

import com.zhiqiangw.canteen.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("BaseService")
public class BaseService implements IBaseService {
    @Autowired
    /**
     * 获取系统当前时间
     */
    public Timestamp getNowTime() {
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        return time1;
    }

    /**
     * @Description: 数字与订单状态的映射关系
     * @Author zhiqiangw
     * @Date 2020/2/16 11:31
     * @param: num
     * @return: java.lang.String
     */
    public String statusExchange(String num) {
        if(num.equals("0"))return "未处理";//订单刚生成，等待管理员确认
        else if(num.equals("1")){//管理员已经确认，等待发货
            return "已处理";
        }
        else if (num.equals("2")){//供应商已经发货，等待入库
            return "已发货";
        }
        else if(num.equals("3")){//订单审核成功，确认入库
            return "已入库";
        }
        else return "拒绝入库";//订单有误，拒绝入库操作
    }
}
