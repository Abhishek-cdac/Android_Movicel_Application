package com.example.movicelselfcare.Model;

public class ServiceCenter {

    String center, address, date;
    int image;

    public ServiceCenter(String center, String address, String date, int image) {

        this.center = center;
        this.address = address;
        this.date = date;
        this.image = image;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
