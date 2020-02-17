package com.zhiqiangw.canteen.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 订单集合表
 */
public class OrderFood implements Serializable {
    private int ordernumber;//订单号
    private String provideraccount;//供应商的账号，提交是空的，有人供应之后就有名字了
    private String totalmoney;//改订单的总钱数
    private String status;
    private Timestamp ordertime;

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getProvideraccount() {
        return provideraccount;
    }

    public void setProvideraccount(String provideraccount) {
        this.provideraccount = provideraccount;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
                "ordernumber=" + ordernumber +
                ", provideraccount='" + provideraccount + '\'' +
                ", totalmoney='" + totalmoney + '\'' +
                ", status='" + status + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }
}
