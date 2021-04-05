package com.example.movicelselfcare.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Model.RechargeModel;
import com.example.movicelselfcare.Model.VoucherHistory;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class VoucherHistoryAdapter extends RecyclerView.Adapter<VoucherHistoryAdapter.MyViewHolder> {

private ArrayList<VoucherHistory> dataSet;
    RadioButton selected = null;
    boolean show = false;
    boolean isRupees = false;

public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textViewPlan;
    TextView textViewPurchasedFor;
    TextView textViewDate;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.textViewPlan = (TextView) itemView.findViewById(R.id.planName);
        this.textViewPurchasedFor = (TextView) itemView.findViewById(R.id.purchasedFor);
        this.textViewDate = (TextView) itemView.findViewById(R.id.date);
        this.img = (ImageView) itemView.findViewById(R.id.imageView);
    }
}

    public VoucherHistoryAdapter(ArrayList<VoucherHistory> data, boolean show, boolean isRupees) {
        this.dataSet = data;
        this.show = show;
        this.isRupees = isRupees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_history_vouchers, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewPlans = holder.textViewPlan;
        TextView textViewPurchasedFor = holder.textViewPurchasedFor;
        TextView textViewDate = holder.textViewDate;
        ImageView img = holder.img;

        textViewPlans.append(dataSet.get(listPosition).getPlanName());
        textViewDate.setText(dataSet.get(listPosition).getDate());
        textViewPurchasedFor.append(dataSet.get(listPosition).getPurchasedFor());
        img.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}