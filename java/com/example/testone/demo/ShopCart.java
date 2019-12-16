package com.example.testone.demo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class ShopCart implements Serializable {

    private String shcartid;
    private String shgoodsid;
    private String shgoodsname;
    private String shgoodsprice;
    private String shgoodsdescribe;
    private String customername;

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setShcartid(String shcartid) {
        this.shcartid = shcartid;
    }

    public void setShgoodsdescribe(String shgoodsdescribe) {
        this.shgoodsdescribe = shgoodsdescribe;
    }

    public void setShgoodsid(String shgoodsid) {
        this.shgoodsid = shgoodsid;
    }

    public void setShgoodsname(String shgoodsname) {
        this.shgoodsname = shgoodsname;
    }

    public void setShgoodsprice(String shgoodsprice) {
        this.shgoodsprice = shgoodsprice;
    }

    public String getCustomername() {
        return customername;
    }

    public String getShcartid() {
        return shcartid;
    }

    public String getShgoodsdescribe() {
        return shgoodsdescribe;
    }

    public String getShgoodsid() {
        return shgoodsid;
    }

    public String getShgoodsname() {
        return shgoodsname;
    }

    public String getShgoodsprice() {
        return shgoodsprice;
    }
}
