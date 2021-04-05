package com.example.movicelselfcare.Model;

public class VoucherHistory {

    String planName, purchasedFor, date;
    int image;

    public VoucherHistory(String planName, String purchasedFor, String date, int image) {

        this.planName = planName;
        this.purchasedFor = purchasedFor;
        this.date = date;
        this.image = image;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPurchasedFor() {
        return purchasedFor;
    }

    public void setPurchasedFor(String purchasedFor) {
        this.purchasedFor = purchasedFor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
