package com.example.movicelselfcare.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Adapters.ServiceCenterAdapter;
import com.example.movicelselfcare.Adapters.VoucherHistoryAdapter;
import com.example.movicelselfcare.Model.ServiceCenter;
import com.example.movicelselfcare.Model.VoucherHistory;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class FragmentServiceCenter extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private Button buy;
    private static RecyclerView recyclerView;
    private static ArrayList<ServiceCenter> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_center, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

       layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String[] plansArray = getResources().getStringArray(R.array.serviceName);
        String[] validityArray = getResources().getStringArray(R.array.address);
        String[] benefitsArray = getResources().getStringArray(R.array.dateTime);
        int[] imagesArray = {R.drawable.green_checkmark_12, R.drawable.green_checkmark_12, R.drawable.red_checkmark_12};

        data = new ArrayList<ServiceCenter>();
        for (int i = 0; i < plansArray.length; i++) {
            data.add(new ServiceCenter(
                    plansArray[i],
                    validityArray[i],
                    benefitsArray[i],
                    imagesArray[i]
            ));
        }

        adapter = new ServiceCenterAdapter(data, false, false);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
