package com.example.magic_food_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private RecyclerView historyRV;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        historyRV = view.findViewById(R.id.history_rv);
        historyRV.setLayoutManager(new LinearLayoutManager(requireContext()));

        ArrayList<History_Model> arrayList = new ArrayList<>();
        arrayList.add(new History_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new History_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new History_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new History_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new History_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new History_Model(R.drawable.rv3,"270","Green Noddle"));
        arrayList.add(new History_Model(R.drawable.rv1,"255","Herbal Pancake"));
        arrayList.add(new History_Model(R.drawable.rv2,"210","Fruit Salad"));
        arrayList.add(new History_Model(R.drawable.rv3,"270","Green Noddle"));

        History_Adapter adapter = new History_Adapter(requireContext(),arrayList);
        historyRV.setAdapter(adapter);
        return view;
    }
}