package com.example.magic_food_app;

public class Menu_Model {
    int menuImg;
    String menuFoodName,menuPrice;

    public Menu_Model(int menuImg, String menuPrice,String menuFoodName) {
        this.menuImg = menuImg;
        this.menuFoodName = menuFoodName;
        this.menuPrice = menuPrice;
    }

    public int getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(int menuImg) {
        this.menuImg = menuImg;
    }

    public String getMenuFoodName() {
        return menuFoodName;
    }

    public void setMenuFoodName(String menuFoodName) {
        this.menuFoodName = menuFoodName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }
}
