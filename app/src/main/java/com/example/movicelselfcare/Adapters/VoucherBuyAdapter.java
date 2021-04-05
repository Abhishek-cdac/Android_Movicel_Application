package com.example.movicelselfcare.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Model.RechargeModel;
import com.example.movicelselfcare.Model.VoucherBuy;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class VoucherBuyAdapter extends RecyclerView.Adapter<VoucherBuyAdapter.MyViewHolder> {

    private ArrayList<VoucherBuy> dataSet;
    RadioButton selected = null;
    boolean show = false;
    boolean isRupees = false;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewPlan;
        TextView textViewValidity;
        TextView textViewBenefits;
        RadioButton radioButton;
        CardView cardBackground;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewPlan = (TextView) itemView.findViewById(R.id.plans);
            this.textViewValidity = (TextView) itemView.findViewById(R.id.validity);
            this.textViewBenefits = (TextView) itemView.findViewById(R.id.benefits);
            this.radioButton = (RadioButton) itemView.findViewById(R.id.radio);

        }
    }

    public VoucherBuyAdapter(ArrayList<VoucherBuy> data, boolean show, boolean isRupees) {
        this.dataSet = data;
        this.show = show;
        this.isRupees = isRupees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_buy_vouchers, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewPlans = holder.textViewPlan;
        TextView textViewValidity = holder.textViewValidity;
        TextView textViewBenefits = holder.textViewBenefits;
        CardView cardBackground = holder.cardBackground;

        if (listPosition == dataSet.size() - 1) {
            if (selected == null) {
                holder.radioButton.setChecked(true);
                selected = holder.radioButton;
            }
        }

        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selected != null) {
                    selected.setChecked(false);
                }
                holder.radioButton.setChecked(true);
                selected = holder.radioButton;
            }
        });

        textViewPlans.setText(dataSet.get(listPosition).getPlan());
        textViewValidity.setText(dataSet.get(listPosition).getValidity());
        textViewBenefits.setText(dataSet.get(listPosition).getBenefits());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}