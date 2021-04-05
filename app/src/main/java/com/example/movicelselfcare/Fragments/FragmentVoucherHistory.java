package com.example.movicelselfcare.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movicelselfcare.Adapters.VoucherHistoryAdapter;
import com.example.movicelselfcare.Adapters.VoucherViewAdapter;
import com.example.movicelselfcare.Model.VoucherHistory;
import com.example.movicelselfcare.Model.VoucherView;
import com.example.movicelselfcare.R;

import java.util.ArrayList;

public class FragmentVoucherHistory extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private Button buy;
    private static RecyclerView recyclerView;
    private static ArrayList<VoucherHistory> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voucher_history, container, false);

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

        String[] plansArray = getResources().getStringArray(R.array.voucherHistP);
        String[] validityArray = getResources().getStringArray(R.array.voucherHistV);
        String[] benefitsArray = getResources().getStringArray(R.array.voucherHistB);
        int[] imagesArray = {R.drawable.green_checkmark_12, R.drawable.red_checkmark_12, R.drawable.red_checkmark_12};

        data = new ArrayList<VoucherHistory>();
        for (int i = 0; i < plansArray.length; i++) {
            data.add(new VoucherHistory(
                    validityArray[i],
                    plansArray[i],
                    benefitsArray[i],
                    imagesArray[i]
            ));
        }

        adapter = new VoucherHistoryAdapter(data, false, false);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
