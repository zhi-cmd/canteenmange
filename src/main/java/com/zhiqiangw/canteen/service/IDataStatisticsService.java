package com.zhiqiangw.canteen.service;

import com.zhiqiangw.canteen.dto.WelcomeDataStatistics;

/**
 * @ClassName IDataStatisticsService
 * @Description 统计数据相关的服务
 * @Author zhiqiangw
 * @DATA 2020-2-17 11:20
 * @Version 1.0
 **/
public interface IDataStatisticsService {
    /**
     * @Description: 获取一个用于welcome界面数据统计需要的数据对象
     * @Author zhiqiangw
     * @Date 2020/2/17 11:24
     * @return: com.zhiqiangw.canteen.dto.WelcomeDataStatistics
     */
    WelcomeDataStatistics getWelcomeDataStatistics();
}
