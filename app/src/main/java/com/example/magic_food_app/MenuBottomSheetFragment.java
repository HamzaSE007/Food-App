package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class MenuBottomSheetFragment extends BottomSheetDialogFragment {


    RecyclerView menuRV;
    ImageButton backBtn;

    public MenuBottomSheetFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false);

        backBtn = view.findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        menuRV = view.findViewById(R.id.menu_rv);
        menuRV.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Menu_Model> arrayList = new ArrayList<>();
        arrayList.add(new Menu_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1,"25","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1,"25","Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3,"270","Green Noddle"));

        Menu_Adapter adapter = new Menu_Adapter(getContext(),arrayList);
        menuRV.setAdapter(adapter);
        return view;
    }
}