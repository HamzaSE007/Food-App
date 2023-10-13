package com.example.magic_food_app;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class NotificationBottomFragment extends BottomSheetDialogFragment {


    private RecyclerView noti_rv;
    private ImageButton noti_backButton;

    public NotificationBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_notification_bottom, container, false);

        noti_backButton = v.findViewById(R.id.noti_backButton);
        noti_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        noti_rv = v.findViewById(R.id.notification_rv);
        noti_rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        ArrayList<Notification_Model> arrayList = new ArrayList<>();
        arrayList.add(new Notification_Model(R.drawable.sademoji,"Your order has been Canceled Successfully"));
        arrayList.add(new Notification_Model(R.drawable.baseline_delivery_dining_24,"Order has been taken by the driver"));
        arrayList.add(new Notification_Model(R.drawable.illustration,"Congrats Your Order Placed"));

        Notification_Adapter adapter = new Notification_Adapter(requireContext(),arrayList);
        noti_rv.setAdapter(adapter);
        return v;
    }
}