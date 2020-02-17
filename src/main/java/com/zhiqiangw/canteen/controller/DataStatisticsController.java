package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.dto.WelcomeDataStatistics;
import com.zhiqiangw.canteen.service.impl.DataStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName DataStatisticsController
 * @Description 与平台数据统计相关的
 * @Author zhiqiangw
 * @DATA 2020-2-17 11:16
 * @Version 1.0
 **/
@Controller
@Api()
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;
    /**
     * @Description: 封装指定的数据跳转welcome界面
     * @Author zhiqiangw
     * @Date 2020/2/17 11:19
     * @param: model
     * @return: java.lang.String
     */
    @GetMapping(value = "/welcome")
    @ApiOperation("跳转欢迎页")
    public String toWelcome(Model model){
        WelcomeDataStatistics welcomeDataStatistics =dataStatisticsService.getWelcomeDataStatistics();
        model.addAttribute("welcomeData",welcomeDataStatistics);
        //跳转welcome.html界面
        return "welcome";
    }
}
