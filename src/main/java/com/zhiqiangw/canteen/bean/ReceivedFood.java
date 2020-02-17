package com.zhiqiangw.canteen.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 每次订单各菜品剩余总量表，就每次进的菜当不同的菜处理。
 */
public class ReceivedFood implements Serializable {
    private String foodname;//
    private int ordernumber;//订单号
    private int fooduid;//
    private String trueamount;//
    private Timestamp finishtime;//配送到的时间

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public int getFooduid() {
        return fooduid;
    }

    public void setFooduid(int fooduid) {
        this.fooduid = fooduid;
    }

    public String getTrueamount() {
        return trueamount;
    }

    public void setTrueamount(String trueamount) {
        this.trueamount = trueamount;
    }

    public Timestamp getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Timestamp finishtime) {
        this.finishtime = finishtime;
    }
}
