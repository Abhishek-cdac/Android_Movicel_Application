package com.example.movicelselfcare.Model;

public class RechargeModel {

    String plans, validity, benefits;

    public RechargeModel(String plans, String validity, String benefits) {
        this.plans = plans;
        this.validity = validity;
        this.benefits = benefits;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
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
