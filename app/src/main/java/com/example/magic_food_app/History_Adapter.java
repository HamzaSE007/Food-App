package com.example.magic_food_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class History_Adapter extends RecyclerView.Adapter<History_Adapter.Holder> {

    Context context;
    ArrayList<History_Model> arrayList;

    public History_Adapter(Context context, ArrayList<History_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public History_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull History_Adapter.Holder holder, int position) {
        History_Model model = arrayList.get(position);
        holder.fImg.setImageResource(model.getHistory_img());
        holder.fName.setText(model.getfName());
        holder.fPrice.setText(model.getfPrice());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView fImg;
        private TextView fName,fPrice;
        public Holder(@NonNull View itemView) {
            super(itemView);
            fImg = itemView.findViewById(R.id.historyItem_cardview_img);
            fName = itemView.findViewById(R.id.historyItem_food_name);
            fPrice = itemView.findViewById(R.id.historyItem_price);
        }
    }
}
