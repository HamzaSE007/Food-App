package com.example.magic_food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PayOut_Activity extends AppCompatActivity {

    private AppCompatButton placeOrder_btn;
    private EditText name_ed,phone_ed,adress_ed;
    private RadioButton codRadioBtn;
    private RadioGroup codRadioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_out);
        placeOrder_btn = findViewById(R.id.placeOrder_btn);
        name_ed = findViewById(R.id.payout_name_ed);
        phone_ed = findViewById(R.id.payout_phone_ed);
        adress_ed = findViewById(R.id.payout_adress_ed);
        codRadioGroup = findViewById(R.id.payout_radioGroup);
        codRadioGroup.clearCheck();

        codRadioBtn = findViewById(codRadioGroup.getCheckedRadioButtonId());

        placeOrder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name_ed.getText().toString();
                String phone = phone_ed.getText().toString();
                String adress = adress_ed.getText().toString();

                int selectedIdRG = codRadioGroup.getCheckedRadioButtonId();
                codRadioBtn = findViewById(selectedIdRG);


                if (TextUtils.isEmpty(name)){
                    name_ed.setError("Please enter Name");
                    name_ed.requestFocus();
                } else if (TextUtils.isEmpty(phone)) {
                    phone_ed.setError("Please enter Phone Number");
                    phone_ed.requestFocus();
                } else if (phone.length() < 11){
                    phone_ed.setError("Please enter valid Phone Number");
                    phone_ed.requestFocus();
                } else if (TextUtils.isEmpty(adress)) {
                    adress_ed.setError("Please enter Address");
                    adress_ed.requestFocus();

                } else if (-1 == codRadioGroup.getCheckedRadioButtonId()) {
                    Toast.makeText(PayOut_Activity.this, "Please select Payment Method", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(PayOut_Activity.this, PlaceOrderSplash_Activity.class));
                    finish();
                }
            }
        });
    }
}