package com.example.movicelselfcare.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Adapters.VoucherBuyAdapter;
import com.example.movicelselfcare.Adapters.VoucherViewAdapter;
import com.example.movicelselfcare.CustomSharedPreferences;
import com.example.movicelselfcare.LoginActivity;
import com.example.movicelselfcare.Model.VoucherBuy;
import com.example.movicelselfcare.Model.VoucherView;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class FragmentVoucherBuy extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private Button buy;
    private CustomSharedPreferences sharedPreferences;
    private static RecyclerView recyclerView;
    private static ArrayList<VoucherBuy> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voucher_buy, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        buy = (Button) view.findViewById(R.id.buy);
        sharedPreferences = new CustomSharedPreferences(getActivity());

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.isGuestLogin()) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("guest", "buyV");
                    startActivityForResult(intent, 100);
                }else {
                    loadFragment(new FragmentBuy());
                }
            }
        });

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String[] plansArray = getResources().getStringArray(R.array.voucherBuyP);
        String[] validityArray =getResources().getStringArray(R.array.voucherBuyV);
        String[] benefitsArray = getResources().getStringArray(R.array.voucherBuyB);

        data = new ArrayList<VoucherBuy>();
        for (int i = 0; i < plansArray.length; i++) {
            data.add(new VoucherBuy(
                    plansArray[i],
                    validityArray[i],
                    benefitsArray[i]
            ));
        }

        adapter = new VoucherBuyAdapter(data, false, false);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", "FragmentVoucherBuy onActivityResult result :  "+resultCode+"   "+requestCode);

        if (resultCode==101){
            loadFragment(new FragmentBuy());
        }
    }
}
