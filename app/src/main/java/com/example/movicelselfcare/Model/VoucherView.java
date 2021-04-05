package com.example.movicelselfcare.Model;

public class VoucherView {

    String cashback, quality;
    int color;

    public VoucherView(String cashback, String quality, int color) {
        this.cashback = cashback;
        this.quality = quality;
        this.color = color;
    }

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
