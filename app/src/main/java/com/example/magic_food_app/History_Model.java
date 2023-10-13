package com.example.magic_food_app;

public class History_Model {
     int history_img;
    String fName,fPrice;

    public History_Model(int history_img, String fPrice,String fName) {
        this.history_img = history_img;
        this.fName = fName;
        this.fPrice = fPrice;
    }

    public int getHistory_img() {
        return history_img;
    }

    public void setHistory_img(int history_img) {
        this.history_img = history_img;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }
}
