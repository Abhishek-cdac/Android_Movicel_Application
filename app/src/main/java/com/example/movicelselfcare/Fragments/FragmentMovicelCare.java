package com.example.movicelselfcare.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.movicelselfcare.R;

public class FragmentMovicelCare extends Fragment {

    private ImageView trackOrder, trackRequest, tips, locate, chat, troubleshoot, faq, videos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movicel_care,container,false);

        android.widget.Toolbar myToolbar = (android.widget.Toolbar) view.findViewById(R.id.my_toolbar);
        getActivity().setActionBar(myToolbar);

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.grey));
        }

        init(view);
        
        return view;
    }

    private void init(View view) {
        trackOrder = view.findViewById(R.id.trackOrder);
        trackRequest = view.findViewById(R.id.trackRequest);
        chat = view.findViewById(R.id.chat);
        troubleshoot = view.findViewById(R.id.troubleshoot);
        locate = view.findViewById(R.id.locate);
        tips = view.findViewById(R.id.tips);
        faq = view.findViewById(R.id.faq);
        videos = view.findViewById(R.id.videos);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentLiveChat(), "chat");
            }
        });

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentLocateUs(), "loc");
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentFAQ(), "faq");
            }
        });

        troubleshoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentTroubleshoot(), "tr");
            }
        });
    }

    private void loadFragment(Fragment fragment, String tag) {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
//                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}