package com.example.movicelselfcare.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Model.VoucherBuy;
import com.example.movicelselfcare.Model.VoucherView;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class VoucherViewAdapter extends RecyclerView.Adapter<VoucherViewAdapter.MyViewHolder> {

    private ArrayList<VoucherView> dataSet;
    Context context;
    boolean show = false;
    boolean isRupees = false;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cashback;
        LinearLayout cardBackground;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cashback = (TextView) itemView.findViewById(R.id.cashback);
            this.cardBackground = (LinearLayout) itemView.findViewById(R.id.back);

        }
    }

    public VoucherViewAdapter(Context context, ArrayList<VoucherView> data, boolean show, boolean isRupees) {
        this.dataSet = data;
        this.context = context;
        this.show = show;
        this.isRupees = isRupees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_view_vouchers, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewCashback = holder.cashback;
        LinearLayout cardBackground = holder.cardBackground;

        cardBackground.setBackgroundColor(context.getResources().getColor(dataSet.get(listPosition).getColor()));
        textViewCashback.setText(dataSet.get(listPosition).getCashback());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}