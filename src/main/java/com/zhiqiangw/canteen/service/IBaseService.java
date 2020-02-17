package com.zhiqiangw.canteen.service;

import java.sql.Timestamp;

public interface IBaseService {
    Timestamp getNowTime();

    /**
     * 将数字标号转化为用户可以理解的标号
     * @param num
     * @return
     */
    String statusExchange(String num);
}
