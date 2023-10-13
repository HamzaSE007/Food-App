package com.example.magic_food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choose_Location_Activity extends AppCompatActivity {
    private AutoCompleteTextView chooseLocation;
    private ArrayList<String> arrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        chooseLocation = findViewById(R.id.listOfLocation);
        arrayList = new ArrayList<>();
        arrayList.add("Ali Town");
        arrayList.add("Thokar Niaz Baig");
        arrayList.add("Johar Town");
        arrayList.add("Kachi Kothi");
        arrayList.add("QazzalBash");
        arrayList.add("Rahima Baad");
        arrayList.add("Agrics Town");
        arrayList.add("Ali-Raza Baad");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        chooseLocation.setAdapter(adapter);

        // title
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Choose Location");
        }
        Toast.makeText(this, "Now You can Choose your Location!", Toast.LENGTH_SHORT).show();

    }
}