package com.zhiqiangw.canteen.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 请求购货表，购物车中的食物
 */
public class AskedFood implements Serializable {
    private String foodname;
    private int fooduid;
    private String askedamount;
    private Timestamp finishtime;
    private int ordernumber;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFooduid() {
        return fooduid;
    }

    public void setFooduid(int fooduid) {
        this.fooduid = fooduid;
    }

    public String getAskedamount() {
        return askedamount;
    }

    public void setAskedamount(String askedamount) {
        this.askedamount = askedamount;
    }

    public Timestamp getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Timestamp finishtime) {
        this.finishtime = finishtime;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        return "AskedFood{" +
                "foodname='" + foodname + '\'' +
                ", fooduid=" + fooduid +
                ", askedamount='" + askedamount + '\'' +
                ", finishtime=" + finishtime +
                ", ordernumber=" + ordernumber +
                ", status='" + status + '\'' +
                '}';
    }
}
