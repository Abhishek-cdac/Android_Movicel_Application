package com.example.movicelselfcare.Fragments;

import android.content.Intent;
import android.os.Bundle;
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

import com.example.movicelselfcare.Adapters.RechargeAdapter;
import com.example.movicelselfcare.CustomSharedPreferences;
import com.example.movicelselfcare.LoginActivity;
import com.example.movicelselfcare.Model.RechargeModel;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class FragmentRecharge4G extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private Button buy;
    private CustomSharedPreferences sharedPreferences;
    private static RecyclerView recyclerView;
    private static ArrayList<RechargeModel> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recharge_all, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        sharedPreferences = new CustomSharedPreferences(getActivity());
        buy = (Button) view.findViewById(R.id.buy);

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

        String[] plansArray = getResources().getStringArray(R.array.plans4G);
        String[] validityArray = getResources().getStringArray(R.array.validity4G);
        String[] benefitsArray = getResources().getStringArray(R.array.benef4G);

        data = new ArrayList<RechargeModel>();
        for (int i = 0; i < plansArray.length; i++) {
            data.add(new RechargeModel(
                    plansArray[i],
                    validityArray[i],
                    benefitsArray[i]
            ));
        }

        adapter = new RechargeAdapter(data, true, false);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==101){
            loadFragment(new FragmentBuy());
        }
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
