package com.example.movicelselfcare.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.movicelselfcare.LoginActivity;
import com.example.movicelselfcare.R;

import java.util.Locale;

public class FragmentSetting extends Fragment {

    private TextView troubleshoot;
    private LinearLayout imgtroubleshoot;
    private Button apply;
    String laun = "en";
    private boolean isExpanded = false;
    private Spinner launguage;
    String[] lan;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_setting, container, false);

        lan = getResources().getStringArray(R.array.launguage);
        android.widget.Toolbar myToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
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
        imgtroubleshoot = view.findViewById(R.id.llExpand);

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

        launguage = view.findViewById(R.id.launguage);

        launguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("English")) {

                    laun = "en";

                }
                if (selectedItem.equals("Portuguese")) {
                    laun = "pt";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        apply = view.findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                troubleshoot.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.forward_20, 0);
                Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                        R.anim.slideup);

                imgtroubleshoot.startAnimation(bottomUp);
                imgtroubleshoot.setVisibility(View.GONE);
                isExpanded = false;

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                if (laun == "pt") {
                    alertDialogBuilder.setMessage(R.string.pt);
                } else {
                    alertDialogBuilder.setMessage(R.string.en);
                }

                alertDialogBuilder.setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Locale myLocale;
                        if (laun == "pt") {
                            myLocale = new Locale("pt", "AO");
                        } else {
                            myLocale = new Locale("en", "US");
                        }

                        Locale.setDefault(myLocale);
                        Configuration config = new Configuration();
                        config.locale = myLocale;
                        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
                        //restart Activity
                        getActivity().finish();

                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, lan);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        launguage.setAdapter(aa);

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