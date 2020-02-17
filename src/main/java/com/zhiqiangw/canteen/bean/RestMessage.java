package com.zhiqiangw.canteen.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName RestMessage
 * @Description
 * @Author zhiqiangw
 * @DATA 2020-2-14 21:47
 * @Version 1.0
 **/
@ApiModel(description= "返回信息")
public class RestMessage implements Serializable {

    @ApiModelProperty(value = "数据数量")
    private String count;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    @ApiModelProperty(value = "返回编号",notes = "0:请求成功")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RestMessage{" +
                "count='" + count + '\'' +
                ", data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
