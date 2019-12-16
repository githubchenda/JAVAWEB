package com.example.testone.demo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class GoodsOrder implements Serializable {

    private String orderid;
    private String goodsname;
    private String orderprice;
    private String customername;
    private String mobile;
    private String address;
    private String mail;
    private String ordertime;
    private String deliverytime;
    private String orderstate;


    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomername() {
        return customername;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrdertime() {
        return ordertime;
    }

}
