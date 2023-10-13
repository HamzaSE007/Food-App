package com.example.magic_food_app;

import android.annotation.SuppressLint;
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

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.Holder> {

    List<Product_DB> productDbList;
    TextView showPrice;

    public myAdapter(List<Product_DB> productDbList,TextView showPrice) {
        this.productDbList = productDbList;
        this.showPrice = showPrice;
    }

    @NonNull
    @Override
    public myAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new Holder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull myAdapter.Holder holder,int position) {

//        Product_DB product = productDbList.get(position);
        holder.pID.setText(String.valueOf(productDbList.get(position).getpID()));
        holder.pImg.setImageResource(productDbList.get(position).getImg());
        holder.pName.setText(productDbList.get(position).getpName());
        holder.pPrice.setText(String.valueOf(productDbList.get(position).getPrice()));
        holder.pQuantity.setText(String.valueOf(productDbList.get(position).getQut()));

        holder.incr.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                int qut = productDbList.get(position).getQut();
                if (qut<10)
                    qut++;
                productDbList.get(position).setQut(qut);
                updatePrice();

                notifyDataSetChanged();



            }
        });

        holder.decr.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                int qut = productDbList.get(position).getQut();
                if (qut>1)
                    qut--;
                productDbList.get(position).setQut(qut);
                updatePrice();

                notifyDataSetChanged();


            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App_DB appDb = Room.databaseBuilder(v.getContext(), App_DB.class,"cart_db").allowMainThreadQueries()
                        .build();
                ProductDao_DB daoDb = appDb.productDao();
                daoDb.deleteById(productDbList.get(position).getpID());
                productDbList.remove(position);
                notifyItemRemoved(position);
                updatePrice();
            }
        });
    }



    @Override
    public int getItemCount() {
        return productDbList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView pImg;
        TextView pID,pName,pPrice,pQuantity;
        AppCompatButton decr,incr;
        ImageButton delete;

        public Holder(@NonNull View itemView) {
            super(itemView);
            pImg = itemView.findViewById(R.id.cart_rv_img);
            pID = itemView.findViewById(R.id.id);
            pName = itemView.findViewById(R.id.cart_food_name);
            pPrice = itemView.findViewById(R.id.cart_food_price);
            pQuantity = itemView.findViewById(R.id.cart_count);
            decr = itemView.findViewById(R.id.cart_minus);
            incr = itemView.findViewById(R.id.cart_plus);
            delete = itemView.findViewById(R.id.cart_delete);
        }
    }

    @SuppressLint("SetTextI18n")
    public void updatePrice() {
        int sum = 0,i;
        for ( i = 0; i<productDbList.size(); i++)
            sum = sum+(productDbList.get(i).getPrice()*productDbList.get(i).getQut());
        showPrice.setText("Total Price PKR: "+sum);
    }
}
