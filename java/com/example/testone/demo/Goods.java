package com.example.testone.demo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class Goods implements Serializable {

    private String goodsid;
    private String goodsname;
    private String goodsprice;
    private String stock;
    private String goodsdescribe;
    private String goodsclass;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setGoodsdescribe(String goodsdescribe) {
        this.goodsdescribe = goodsdescribe;
    }

    public String getGoodsdescribe() {
        return goodsdescribe;
    }

    public void setGoodsclass(String goodsclass) {
        this.goodsclass = goodsclass;
    }

    public String getGoodsclass() {
        return goodsclass;
    }
}
