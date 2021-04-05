package com.example.movicelselfcare.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Model.RechargeModel;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class RechargeAdapter extends RecyclerView.Adapter<RechargeAdapter.MyViewHolder> {

private ArrayList<RechargeModel> dataSet;
    RadioButton selected = null;
    boolean show = false;
    boolean isRupees = false;

public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textViewPlan;
    TextView textViewValidity;
    TextView textViewBenefits;
    TextView unlimited;
    RadioButton radioButton;
    CardView cardBackground;


    public MyViewHolder(View itemView) {
        super(itemView);
        this.textViewPlan = (TextView) itemView.findViewById(R.id.plans);
        this.textViewValidity = (TextView) itemView.findViewById(R.id.validity);
        this.textViewBenefits = (TextView) itemView.findViewById(R.id.benefits);
        this.unlimited = (TextView) itemView.findViewById(R.id.unlimited);
        this.radioButton = (RadioButton) itemView.findViewById(R.id.isSelected);
        this.cardBackground = (CardView) itemView.findViewById(R.id.card_view);

    }
}

    public RechargeAdapter(ArrayList<RechargeModel> data, boolean show, boolean isRupees) {
        this.dataSet = data;
        this.show = show;
        this.isRupees = isRupees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_recharge, parent, false);

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
        TextView unlimited = holder.unlimited;

        if (show){
            unlimited.setVisibility(View.GONE);
        }

       if (listPosition%2==0){
            cardBackground.setBackgroundResource(R.color.lightergrey);
        }else{
            cardBackground.setBackgroundResource(R.color.white);
        }

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

        textViewPlans.setText(dataSet.get(listPosition).getPlans());
        textViewValidity.setText(dataSet.get(listPosition).getValidity());
        textViewBenefits.append(dataSet.get(listPosition).getBenefits());
//        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}