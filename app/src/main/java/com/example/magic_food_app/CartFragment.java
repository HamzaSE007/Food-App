package com.example.magic_food_app;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppCompatButton proceedBtn;
    private TextView rateView;


    public CartFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        proceedBtn = v.findViewById(R.id.cart_btn_proceed);
        rateView = v.findViewById(R.id.rateview);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), PayOut_Activity.class));
            }
        });


        recyclerView = v.findViewById(R.id.cart_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        App_DB app_db = Room.databaseBuilder(requireContext(), App_DB.class,"cart_db").allowMainThreadQueries()
                .build();
        ProductDao_DB dao_db = app_db.productDao();

        List<Product_DB> product = dao_db.getAllProduct();

        myAdapter adapter = new myAdapter(product,rateView);

        recyclerView.setAdapter(adapter);

        int sum = 0,i;
        for (i = 0; i<product.size(); i++)
            sum = sum+(product.get(i).getPrice()*product.get(i).getQut());

        rateView.setText("Total Price PKR: "+sum);


        return v;
    }
}