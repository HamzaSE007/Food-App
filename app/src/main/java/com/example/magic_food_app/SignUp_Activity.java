package com.example.magic_food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Activity extends AppCompatActivity {

    private TextView signupToLogin;
    private AppCompatButton reg_btn;
    private EditText reg_name_ed, reg_email_ed, reg_password_ed;
    private static final String TAG = "SignUp_Activity";
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        reg_name_ed = findViewById(R.id.reg_name_ed);
        reg_email_ed = findViewById(R.id.reg_email_ed);
        reg_password_ed = findViewById(R.id.reg_password_ed);

        // set Listener on btn
        reg_btn = findViewById(R.id.reg_btn);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = reg_name_ed.getText().toString();
                String email = reg_email_ed.getText().toString();
                String password = reg_password_ed.getText().toString();
                
                if (TextUtils.isEmpty(name)){
                    reg_name_ed.setError("Please enter name");
                    reg_name_ed.requestFocus();
                } else if (TextUtils.isEmpty(email)) {
                    reg_email_ed.setError("Please enter Email");
                    reg_email_ed.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    reg_email_ed.setError("Please valid Email");
                    reg_email_ed.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    reg_password_ed.setError("Please enter Password");
                    reg_password_ed.requestFocus();
                } else if (password.length() < 6) {
                    reg_password_ed.setError("Please enter at least six character");
                    reg_password_ed.requestFocus();
                } else {

                    dialog = new ProgressDialog(SignUp_Activity.this);
                    dialog.setTitle("Please wait...");
                   registerUser(name,email,password);
                }
            }
        });

        // set Listener on signup to login page
        signupToLogin = findViewById(R.id.reg_login);
        signupToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp_Activity.this, Login_Activity.class));
                finish();

            }
        });

        // Title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Register");
        }
        //Toast
        Toast.makeText(this, "Now You can Register!", Toast.LENGTH_SHORT).show();


    }

    private void registerUser(String name, String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp_Activity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    FirebaseUser user = auth.getCurrentUser();

                    ReadWriteUserDetail readWriteUserDetail = new ReadWriteUserDetail(name);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    assert user != null;
                    reference.child(user.getUid()).setValue(readWriteUserDetail).addOnCompleteListener(
                            new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUp_Activity.this, "User Register Successfully...", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignUp_Activity.this, Choose_Location_Activity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(SignUp_Activity.this, "User Register Failed! Try again",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                } else {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        reg_password_ed.setError("Your Password is too Weak");
                        reg_password_ed.requestFocus();
                    } catch (FirebaseAuthEmailException e) {
                        reg_email_ed.setError("Email is invalid or already taken...");
                        reg_email_ed.requestFocus();
                    } catch (FirebaseAuthUserCollisionException e) {
                        reg_email_ed.setError("Email is already taken...");
                        reg_email_ed.requestFocus();
                        Toast.makeText(SignUp_Activity.this, "User already Register", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage());
                        Toast.makeText(SignUp_Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
    }