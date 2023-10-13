package com.example.magic_food_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product_DB {

    @PrimaryKey(autoGenerate = true)
    public int pID;

    @ColumnInfo(name = "pImg")
    public int img;

    @ColumnInfo(name = "pName")
    public String pName;

    @ColumnInfo(name = "pPrice")
    public int price;

    @ColumnInfo(name = "quantity")
    public int qut;

    public Product_DB(int pID,int img ,String pName, int price, int qut) {
        this.pID = pID;
        this.img = img;
        this.pName = pName;
        this.price = price;
        this.qut = qut;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQut() {
        return qut;
    }

    public void setQut(int qut) {
        this.qut = qut;
    }
}
