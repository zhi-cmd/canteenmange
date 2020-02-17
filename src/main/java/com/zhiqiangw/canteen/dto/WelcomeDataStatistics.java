package com.zhiqiangw.canteen.dto;

import java.io.Serializable;

/**
 * @ClassName WelcomeDataStatistics
 * @Description 针对welcome界面的数据统计模块设计的数据传输层dto
 * @Author zhiqiangw
 * @DATA 2020-2-14 17:44
 * @Version 1.0
 **/
public class WelcomeDataStatistics implements Serializable {
    private int totalOrder;//总订单数
    private int completeOrder;//完成订单数
    private int totalUsers;//系统用户总人数
    private int totalFood;//菜品总数
    private int highAlarm;//上限报警数
    private int lowAlarm;//下限报警数

    public int getTotalOrder() {
        return totalOrder;
    }

    public int getCompleteOrder() {
        return completeOrder;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public int getTotalFood() {
        return totalFood;
    }

    public int getHighAlarm() {
        return highAlarm;
    }

    public int getLowAlarm() {
        return lowAlarm;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public void setCompleteOrder(int completeOrder) {
        this.completeOrder = completeOrder;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public void setTotalFood(int totalFood) {
        this.totalFood = totalFood;
    }

    public void setHighAlarm(int highAlarm) {
        this.highAlarm = highAlarm;
    }

    public void setLowAlarm(int lowAlarm) {
        this.lowAlarm = lowAlarm;
    }

    @Override
    public String toString() {
        return "WelcomeDataStatistics{" +
                "totalOrder=" + totalOrder +
                ", completeOrder=" + completeOrder +
                ", totalUsers=" + totalUsers +
                ", totalFood=" + totalFood +
                ", highAlarm=" + highAlarm +
                ", lowAlarm=" + lowAlarm +
                '}';
    }
}
