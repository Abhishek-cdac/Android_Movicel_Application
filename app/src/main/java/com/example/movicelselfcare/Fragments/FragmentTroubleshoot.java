package com.example.movicelselfcare.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.movicelselfcare.R;

public class FragmentTroubleshoot extends Fragment {

    private TextView troubleshoot;
    private ImageView imgtroubleshoot;
    private boolean isExpanded = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.movicel_care_troubleshoot, container, false);

        android.widget.Toolbar myToolbar = (android.widget.Toolbar) view.findViewById(R.id.my_toolbar);
        getActivity().setActionBar(myToolbar);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.grey));
        }

        troubleshoot = view.findViewById(R.id.expandTroubleshoot);
        imgtroubleshoot = view.findViewById(R.id.troubleshoot);

        troubleshoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isExpanded) {
                    troubleshoot.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.expand_arrow_20, 0);

                    Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                            R.anim.slidedown);

                    imgtroubleshoot.startAnimation(bottomUp);
                    imgtroubleshoot.setVisibility(View.VISIBLE);

                    isExpanded = true;
                } else {
                    troubleshoot.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.forward_20, 0);
                    Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                            R.anim.slideup);

                    imgtroubleshoot.startAnimation(bottomUp);
                    imgtroubleshoot.setVisibility(View.GONE);
                    isExpanded = false;
                }
            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                getFragmentManager().popBackStack();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}