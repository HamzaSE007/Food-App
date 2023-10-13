package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.ViewHolder> implements Filterable {
    Context context;
    ArrayList<Menu_Model> arrayList;
    ArrayList<Menu_Model> arrayListFull;



    public Menu_Adapter(Context context, ArrayList<Menu_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        arrayListFull = new ArrayList<>(arrayList);

    }

    @NonNull
    @Override
    public Menu_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Menu_Adapter.ViewHolder holder, int position) {
        Menu_Model model = arrayList.get(position);
        holder.menuFoodImg.setImageResource(model.getMenuImg());
        holder.price.setText(model.getMenuPrice());
        holder.foodName.setText(model.getMenuFoodName());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menuFoodImg;
        TextView price,foodName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuFoodImg = itemView.findViewById(R.id.menu_img);
            price = itemView.findViewById(R.id.menu_food_price);
            foodName = itemView.findViewById(R.id.menu_food_title);
        }
    }
    private final Filter exampleFilter = new Filter() {
        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Menu_Model> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(arrayListFull);
                notifyDataSetChanged();
            }
            else {
                String filterItem = constraint.toString().toLowerCase().trim();
                for ( Menu_Model item : arrayListFull) {
                    if (item.getMenuFoodName().toLowerCase().contains(filterItem)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }


        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

                arrayList.clear();
                arrayList.addAll((ArrayList)results.values);
                notifyDataSetChanged();

        }
    };
}
