package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    RecyclerView searchRV;
    SearchView searchView;

    public SearchFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        searchRV = v.findViewById(R.id.search_rv);
        searchRV.setLayoutManager(new LinearLayoutManager(requireContext()));
        ArrayList<Menu_Model> arrayList = new ArrayList<>();
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));
        arrayList.add(new Menu_Model(R.drawable.rv1, "255", "Herbal Pancake"));
        arrayList.add(new Menu_Model(R.drawable.rv2, "210", "Fruit Salad"));
        arrayList.add(new Menu_Model(R.drawable.rv3, "270", "Green Noddle"));

     ArrayList<Menu_Model> arrayListFull = new ArrayList<>();
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));
        arrayListFull.add(new Menu_Model(R.drawable.rv1, "$5", "Herbal Pancake"));
        arrayListFull.add(new Menu_Model(R.drawable.rv2, "$10", "Fruit Salad"));
        arrayListFull.add(new Menu_Model(R.drawable.rv3, "$7", "Green Noddle"));




        Menu_Adapter adapter = new Menu_Adapter(getContext(), arrayList);
        searchRV.setAdapter(adapter);


        searchView = v.findViewById(R.id.searchBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return v;
    }


}