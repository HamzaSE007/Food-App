package com.example.magic_food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_Pass_Activity extends AppCompatActivity {

    private AppCompatButton resetPassBtn;
    private ProgressBar fpProgressBar;
    private FirebaseAuth auth;
    private EditText emailFP;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        resetPassBtn = findViewById(R.id.resetPass_btn);
        fpProgressBar = findViewById(R.id.fp_progress_bar);
        emailFP = findViewById(R.id.fp_email_ed);

        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailFP.getText().toString();

                if (TextUtils.isEmpty(email)){
                    emailFP.setError("Please enter Email");
                    emailFP.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailFP.setError("Please Enter Valid Email");
                    emailFP.requestFocus();

                }
                else {
                    fpProgressBar.setVisibility(View.VISIBLE);
                    resetPassword(email);
                }
            }
        });
    }

    private void resetPassword(String email) {
        auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Forget_Pass_Activity.this, "Please check your Email inbox", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Forget_Pass_Activity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Forget_Pass_Activity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
                fpProgressBar.setVisibility(View.GONE);
            }

        });
    }
}