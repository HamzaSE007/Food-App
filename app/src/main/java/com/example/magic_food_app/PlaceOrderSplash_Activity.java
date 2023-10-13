package com.example.magic_food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaceOrderSplash_Activity extends AppCompatActivity {

    private AppCompatButton backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_splash);
        backHome = findViewById(R.id.backHome_btn);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlaceOrderSplash_Activity.this, MainActivity.class));
                finish();
            }
        });
    }
}