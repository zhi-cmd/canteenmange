package com.zhiqiangw.canteen.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class HistoryBuy implements Serializable {
    private int foodid;

    private Timestamp time;

    private int buynumber;

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getBuynumber() {
        return buynumber;
    }

    public void setBuynumber(int buynumber) {
        this.buynumber = buynumber;
    }

    @Override
    public String toString() {
        return "HistoryBuy{" +
                "foodid=" + foodid +
                ", time=" + time +
                ", buynumber=" + buynumber +
                '}';
    }
}
