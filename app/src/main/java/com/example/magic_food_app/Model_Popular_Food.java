package com.example.magic_food_app;

public class Model_Popular_Food {
    int img,pid;
    String price,food_name;

    public Model_Popular_Food(int img, String price, String food_name,int pid) {
        this.pid = pid;
        this.img = img;
        this.price = price;
        this.food_name = food_name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
}
