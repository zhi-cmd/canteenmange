package com.zhiqiangw.canteen.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class HistoryUse implements Serializable {
    private int foodid;
    private Timestamp time;
    private int usenumber;

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

    public int getUsenumber() {
        return usenumber;
    }

    public void setUsenumber(int usenumber) {
        this.usenumber = usenumber;
    }

    @Override
    public String toString() {
        return "historyuse{" +
                "foodid=" + foodid +
                ", time=" + time +
                ", usenumber=" + usenumber +
                '}';
    }
}
