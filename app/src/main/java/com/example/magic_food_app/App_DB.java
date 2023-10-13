package com.example.magic_food_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product_DB.class}, version = 1)
public abstract class App_DB extends RoomDatabase {

    public abstract ProductDao_DB productDao();

}
