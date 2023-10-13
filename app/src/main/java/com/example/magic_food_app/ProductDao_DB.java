package com.example.magic_food_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao_DB {

    @Insert
    void insertRecord(Product_DB product);

    @Query("SELECT EXISTS(SELECT * FROM Product_DB WHERE pID = :productID )")
    Boolean is_exist(int productID);

    @Query("SELECT * FROM Product_DB")
    List<Product_DB> getAllProduct();

    @Query("DELETE FROM PRODUCT_DB WHERE pID = :id")
    void deleteById(int id);
}
