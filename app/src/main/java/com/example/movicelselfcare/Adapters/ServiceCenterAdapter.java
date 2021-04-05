package com.example.movicelselfcare.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Model.ServiceCenter;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class ServiceCenterAdapter extends RecyclerView.Adapter<ServiceCenterAdapter.MyViewHolder> {

private ArrayList<ServiceCenter> dataSet;
    RadioButton selected = null;
    boolean show = false;
    boolean isRupees = false;

public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textViewServiceCenter;
    TextView textViewAddress;
    TextView textViewDate;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.textViewServiceCenter = (TextView) itemView.findViewById(R.id.center);
        this.textViewAddress = (TextView) itemView.findViewById(R.id.address);
        this.textViewDate = (TextView) itemView.findViewById(R.id.date);
        this.img = (ImageView) itemView.findViewById(R.id.imageView);
    }
}

    public ServiceCenterAdapter(ArrayList<ServiceCenter> data, boolean show, boolean isRupees) {
        this.dataSet = data;
        this.show = show;
        this.isRupees = isRupees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_service_center, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewServiceCenters = holder.textViewServiceCenter;
        TextView textViewAddress = holder.textViewAddress;
        TextView textViewDate = holder.textViewDate;
        ImageView img = holder.img;

        textViewServiceCenters.setText(dataSet.get(listPosition).getCenter());
        textViewDate.setText(dataSet.get(listPosition).getDate());
        textViewAddress.setText(dataSet.get(listPosition).getAddress());
        img.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}