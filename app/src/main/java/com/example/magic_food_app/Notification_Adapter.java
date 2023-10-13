package com.example.magic_food_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.BindException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.Holder> {

    Context context;
    ArrayList<Notification_Model> arrayList;

    public Notification_Adapter(Context context, ArrayList<Notification_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Notification_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notication_item,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Notification_Adapter.Holder holder, int position) {
        Notification_Model model = arrayList.get(position);
        holder.noti_img.setImageResource(model.getNoti_img());
        holder.noti_tv.setText(model.getNoti_msg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        CircleImageView noti_img;
         TextView noti_tv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            noti_img =(CircleImageView) itemView.findViewById(R.id.noti_img);
            noti_tv = itemView.findViewById(R.id.noti_tv);
        }
    }
}
