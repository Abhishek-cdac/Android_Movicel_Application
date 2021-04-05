package com.example.movicelselfcare.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Adapters.RechargeAdapter;
import com.example.movicelselfcare.Adapters.VoucherViewAdapter;
import com.example.movicelselfcare.Model.RechargeModel;
import com.example.movicelselfcare.Model.VoucherHistory;
import com.example.movicelselfcare.Model.VoucherView;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class FragmentVoucherView extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private Button buy;
    private static RecyclerView recyclerView;
    private static ArrayList<VoucherView> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voucher_view, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        buy = (Button) view.findViewById(R.id.buy);
        buy.setVisibility(View.GONE);

       /* buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FragmentBuy.class);
                startActivity(intent);
            }
        });*/

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String[] plansArray = getResources().getStringArray(R.array.voucherVwP);
        String[] validityArray = getResources().getStringArray(R.array.voucherVwV);
        int[] benefitsArray = {R.color.yellow, R.color.blue, R.color.orange};

        data = new ArrayList<VoucherView>();
        for (int i = 0; i < plansArray.length; i++) {
            data.add(new VoucherView(
                    plansArray[i],
                    validityArray[i],
                    benefitsArray[i]
            ));
        }

        adapter = new VoucherViewAdapter(getActivity(), data, false, false);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
