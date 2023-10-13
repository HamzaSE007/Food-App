package com.example.magic_food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ImageButton notification_bell;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.footer);
        notification_bell = findViewById(R.id.notification_bell);


        notification_bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               NotificationBottomFragment dialogFragment = new NotificationBottomFragment();
               dialogFragment.show(getSupportFragmentManager(),"Test");
            }
        });

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home){
                    loadFrag(new HomeFragment(),false);
                } else if (id == R.id.nav_cart) {
                    loadFrag(new CartFragment(),false);
                } else if (id == R.id.nav_search) {
                    loadFrag(new SearchFragment(),false);
                } else if (id == R.id.nav_list) {
                    loadFrag(new ListFragment(),false);
                } else {
                    loadFrag(new ProfileFragment(),false);
                }
                return true;
            }
        });

        navigationView.setSelectedItemId(R.id.nav_home);
    }



    @SuppressLint("CommitTransaction")
    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }
}