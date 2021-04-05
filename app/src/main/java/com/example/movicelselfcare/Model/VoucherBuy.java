package com.example.movicelselfcare.Model;

public class VoucherBuy {

    String plan, validity, benefits;

    public VoucherBuy(String plan, String validity, String benefits) {
        this.plan = plan;
        this.validity = validity;
        this.benefits = benefits;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
