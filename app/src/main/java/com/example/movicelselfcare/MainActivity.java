package com.example.movicelselfcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.movicelselfcare.Fragments.FragmentCoupons;
import com.example.movicelselfcare.Fragments.FragmentMovicelCare;
import com.example.movicelselfcare.Fragments.FragmentRecharge;
import com.example.movicelselfcare.Fragments.FragmentVoucher;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Boolean isExit = false;
    private BottomNavigationView bottomNavigationView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @SuppressLint({"MissingPermission", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment;

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        fragment = new Dashboard();
                        loadFragmentmain(fragment);
                        return true;

                    case R.id.recharge:
                        fragment = new FragmentRecharge();
                        loadFragment(fragment);
                        return true;

                    case R.id.myVouchers:

                        fragment = new FragmentVoucher();
                        loadFragment(fragment);
                        return true;

                    case R.id.coupons:

                        fragment = new FragmentCoupons();
                        loadFragment(fragment);
                        return true;

                    case R.id.movicelCare:

                        fragment = new FragmentMovicelCare();
                        loadFragment(fragment);
                        return true;

                    default:
                        return true;

                }
            }
        });

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.red));
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        loadFragmentmain(new Dashboard());
    }

    @Override
    protected void onResume() {
        super.onResume();

        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBackPressed() {

        if (isExit) {
            finish(); // finish activity
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.backPress),
                    Toast.LENGTH_SHORT);
            View view = toast.getView();

            view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);

            TextView text = view.findViewById(android.R.id.message);
            text.setTextColor(getResources().getColor(R.color.white));
            toast.show();

            isExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 3 * 1000);
        }
    }

    private void loadFragmentmain(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", "MainActivity onActivityResult");
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}