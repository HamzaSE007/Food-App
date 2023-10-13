package com.example.magic_food_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {
    private TextView loginToSignUp,forgotPass_TV;
    private AppCompatButton login_btn;
    private EditText login_email_ed,login_password_ed;
    private FirebaseAuth authProfile;
    private static final String TAG = "SignUp_Activity";

    private AppCompatButton googleSignUp;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_btn);
        loginToSignUp = findViewById(R.id.login_reg);
        login_email_ed = findViewById(R.id.login_email_ed);
        login_password_ed = findViewById(R.id.login_password_ed);
        googleSignUp = findViewById(R.id.login_google_btn);
        forgotPass_TV = findViewById(R.id.forgotPass_TV);


        // Reset Password
        forgotPass_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login_Activity.this, "Now Reset Your Password", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login_Activity.this, Forget_Pass_Activity.class));
            }
        });

        // SignUp with Google
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        gsc = GoogleSignIn.getClient(this,gso);

        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigUp();
            }
        });


        // Title
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Login");
        }
        //Toast
        Toast.makeText(this, "Now You can Login", Toast.LENGTH_SHORT).show();

        // Set Listener on Login Button
        loginToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, SignUp_Activity.class));
                finish();
            }
        });

        authProfile = FirebaseAuth.getInstance();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_email_ed.getText().toString();
                String password = login_password_ed.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    login_email_ed.setError("Please enter Email");
                    login_email_ed.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    login_email_ed.setError("Please valid Email");
                    login_email_ed.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    login_password_ed.setError("Please enter Password");
                    login_password_ed.requestFocus();
                } else if (password.length() < 6) {
                    login_password_ed.setError("Please enter at least six character");
                    login_password_ed.requestFocus();
                } else{
                    loginUser(email,password);
                }
            }
        });

    }

    private void sigUp() {
        Intent intent = gsc.getSignInIntent();
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);

                // intent
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            } catch (ApiException e) {
                Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loginUser(String email, String password) {
        authProfile.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Login_Activity.this, "User Login Successfully...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    try {
                        task.getException();
                    }catch (Exception e){
                        Log.d(TAG, e.getMessage());
                        Toast.makeText(Login_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Login_Activity.this, "User Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // check if user already registered login automatic...
    @Override
    protected void onStart() {
        super.onStart();
        if (authProfile.getCurrentUser() != null){
            Toast.makeText(this, "You Already Login!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login_Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Login_Activity.this, "You Can Login Now!", Toast.LENGTH_SHORT).show();
        }
    }
}