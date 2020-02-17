package com.zhiqiangw.canteen.bean;

import java.io.Serializable;

/**
 * @Description: DAO，与数据库中food表对应。
 * @Author zhiqiangw
 * @Date 2020/2/14 18:00
 */
public class FoodStore implements Serializable {
    private String foodname;//食物名称
    private int foodid;//食物编号
    private String foodamount;//剩余数量
    private String alarmamount;//报警数量
    private String lowalarmamount;//低报警数量
    private String money;//单价
    private int changenum;

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getFoodamount() {
        return foodamount;
    }

    public void setFoodamount(String foodamount) {
        this.foodamount = foodamount;
    }

    public String getAlarmamount() {
        return alarmamount;
    }

    public void setAlarmamount(String alarmamount) {
        this.alarmamount = alarmamount;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getChangenum() {
        return changenum;
    }

    public void setChangenum(int changenum) {
        this.changenum = changenum;
    }

    public String getLowalarmamount() {
        return lowalarmamount;
    }

    public void setLowalarmamount(String lowalarmamount) {
        this.lowalarmamount = lowalarmamount;
    }

    @Override
    public String toString() {
        return "FoodStore{" +
                "foodname='" + foodname + '\'' +
                ", foodid=" + foodid +
                ", foodamount='" + foodamount + '\'' +
                ", alarmamount='" + alarmamount + '\'' +
                ", money='" + money + '\'' +
                ", changenum=" + changenum +
                '}';
    }
}
