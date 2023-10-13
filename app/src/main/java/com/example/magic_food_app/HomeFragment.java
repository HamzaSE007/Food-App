package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

   ImageSlider imageSlider;
   RecyclerView recyclerView;
   TextView view_menu;

    public HomeFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner4, ScaleTypes.FIT));
        imageSlider.setImageList(imageList);


        recyclerView = view.findViewById(R.id.rv_homeFrag);
        ArrayList<Model_Popular_Food> arrayList = new ArrayList<>();
        arrayList.add(new Model_Popular_Food(R.drawable.rv1,"255","Herbal Pancake",1));
        arrayList.add(new Model_Popular_Food(R.drawable.rv2,"210","Fruit Salad",2));
        arrayList.add(new Model_Popular_Food(R.drawable.rv3,"270","Green Noddle",3));
        arrayList.add(new Model_Popular_Food(R.drawable.rv1,"255","Herbal Pancake",4));
        arrayList.add(new Model_Popular_Food(R.drawable.rv2,"210","Fruit Salad",5));
        arrayList.add(new Model_Popular_Food(R.drawable.rv3,"270","Green Noddle",6));
        arrayList.add(new Model_Popular_Food(R.drawable.rv1,"255","Herbal Pancake",7));
        arrayList.add(new Model_Popular_Food(R.drawable.rv2,"210","Fruit Salad",8));
        arrayList.add(new Model_Popular_Food(R.drawable.rv3,"270","Green Noddle",9));
        Popular_Food_Adapter adapter = new Popular_Food_Adapter(getContext(),arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        view_menu = view.findViewById(R.id.view_menu);
        view_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MenuBottomSheetFragment bottomSheetFragment = new MenuBottomSheetFragment();
               bottomSheetFragment.show(getParentFragmentManager(),"Test");

            }
        });

        return view;
    }
}