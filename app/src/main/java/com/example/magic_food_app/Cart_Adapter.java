package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.Holder> {
    Context context;
   ArrayList<Cart_Model> arrayList;


    public Cart_Adapter(Context context,   ArrayList<Cart_Model> arrayList) {
        this.context = context;
        this. arrayList =  arrayList;

    }

    @NonNull
    @Override
    public Cart_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false);
        return new Holder(v);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull Cart_Adapter.Holder holder,  int position) {
       Cart_Model product = arrayList.get(position);
       holder.productID.setText(String.valueOf(product.getId()));
        holder.cart_img.setImageResource(product.getImg());
        holder.cart_price.setText(product.getPrice());
        holder.cart_food.setText(product.getpName());
        holder.cart_countItem.setText(String.valueOf(product.getQuantity()));
        holder.incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int quantity = product.getQuantity();
               if (quantity<10) {
                   quantity++;
                   product.setQuantity(quantity);
               }
               notifyDataSetChanged();
            }
        });
        holder.decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int quantity = product.getQuantity();
               if (quantity>1) {
                   quantity--;
                   product.setQuantity(quantity);
               }
               notifyDataSetChanged();
            }
        });

        holder.del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
                notifyDataSetChanged();
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,arrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView cart_img;
        TextView cart_price,cart_food,cart_countItem,productID;
        ImageButton del_btn;
        AppCompatButton incr,decr;
        public Holder(@NonNull View itemView) {
            super(itemView);
            cart_img = itemView.findViewById(R.id.cart_rv_img);
            cart_price = itemView.findViewById(R.id.cart_food_price);
            cart_food = itemView.findViewById(R.id.cart_food_name);
            cart_countItem = itemView.findViewById(R.id.cart_count);
            del_btn = itemView.findViewById(R.id.cart_delete);
            incr = itemView.findViewById(R.id.cart_plus);
            decr = itemView.findViewById(R.id.cart_minus);
            productID = itemView.findViewById(R.id.id);
        }
    }
}
