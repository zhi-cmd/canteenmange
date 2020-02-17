package com.zhiqiangw.canteen.bean;

import java.io.Serializable;

public class ProviderMsg implements Serializable {
    private String providernum;//供应商账号
    private String shopname;//店铺名
    private String connect;//联系方式
    private String shopmsg;//店铺描述
    private String location;//详细地址
    private String license;//营业执照
    private String status;//状态，0待认证，1认证成功

    public String getProvidernum() {
        return providernum;
    }

    public void setProvidernum(String providernum) {
        this.providernum = providernum;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getShopmsg() {
        return shopmsg;
    }

    public void setShopmsg(String shopmsg) {
        this.shopmsg = shopmsg;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProviderMsg{" +
                "providernum='" + providernum + '\'' +
                ", shopname='" + shopname + '\'' +
                ", connect='" + connect + '\'' +
                ", shopmsg='" + shopmsg + '\'' +
                ", location='" + location + '\'' +
                ", license='" + license + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
