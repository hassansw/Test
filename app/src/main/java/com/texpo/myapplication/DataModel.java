package com.texpo.myapplication;

public class DataModel {

    String desc;
    String height;
    String width;
    String qty;

    public String getDesc() { return desc; }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSFT() {
        return SFT;
    }

    public void setSFT(String SFT) {
        this.SFT = SFT;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    String SFT;
    String rates;
    String amount;


}