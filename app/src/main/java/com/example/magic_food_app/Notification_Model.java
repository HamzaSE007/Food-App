package com.example.magic_food_app;

public class Notification_Model {
    int noti_img;
    String  noti_msg;

    public Notification_Model(int noti_img, String noti_msg) {
        this.noti_img = noti_img;
        this.noti_msg = noti_msg;
    }

    public int getNoti_img() {
        return noti_img;
    }

    public void setNoti_img(int noti_img) {
        this.noti_img = noti_img;
    }

    public String getNoti_msg() {
        return noti_msg;
    }

    public void setNoti_msg(String noti_msg) {
        this.noti_msg = noti_msg;
    }
}
