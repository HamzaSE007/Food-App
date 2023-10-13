package com.example.magic_food_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Popular_Food_Adapter extends RecyclerView.Adapter<Popular_Food_Adapter.Holder> {

    Context context;
    ArrayList<Model_Popular_Food> arrayList;

    public Popular_Food_Adapter(Context context, ArrayList<Model_Popular_Food> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Popular_Food_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_item,parent,false);
        return new Holder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull Popular_Food_Adapter.Holder holder,int position) {
        Model_Popular_Food model = arrayList.get(position);
        holder.food_img.setImageResource(model.getImg());
        holder.price.setText(model.getPrice());
        holder.title.setText(model.getFood_name());

        holder.addTocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              App_DB app_db = Room.databaseBuilder(context, App_DB.class,"cart_db").allowMainThreadQueries()
                      .build();
              ProductDao_DB dao = app_db.productDao();
              Boolean checkID = dao.is_exist(arrayList.get(position).getPid());
              if (!checkID){
                  int img = model.getImg();
                  String name = model.getFood_name();
                  int price = Integer.parseInt(model.getPrice());
                  int pid = model.getPid();
                  dao.insertRecord(new Product_DB(pid,img,name,price,1));
                  Toast.makeText(context, "Product Add Cart Successfully", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(context, "Product Already in Cart", Toast.LENGTH_SHORT).show();
              }

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView food_img;
        TextView title,price,addTocart,pid;
        public Holder(@NonNull View itemView) {
            super(itemView);
            food_img = itemView.findViewById(R.id.popular_img);
            title = itemView.findViewById(R.id.popular_food_title);
            price = itemView.findViewById(R.id.popular_food_price);
            addTocart = itemView.findViewById(R.id.addToCart);
            pid = itemView.findViewById(R.id.productId);

        }
    }

}
