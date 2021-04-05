package com.example.movicelselfcare;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class SplashScreen extends AppCompatActivity {

    CustomSharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        sharedPreferences = new CustomSharedPreferences(SplashScreen.this);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.red));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();

                Locale myLocale;

                Log.d("test", "getLaund : " + sharedPreferences.getLanguage());

                if (sharedPreferences.getLanguage().equalsIgnoreCase("pt")) {
                    myLocale = new Locale("pt", "AO");
                    sharedPreferences.setLanguage("pt");
                } else {
                    myLocale = new Locale("en", "US");
                    sharedPreferences.setLanguage("en");
                }

                Locale.setDefault(myLocale);
                Configuration config = new Configuration();
                config.locale = myLocale;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);

            }
        }, 1000);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    public static void setLocale(Activity context) {
        Locale locale;
        //Log.e("Lan",session.getLanguage());
        locale = new Locale("pt_AO");
        Configuration config = new Configuration(context.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        context.getBaseContext().getResources().updateConfiguration(config,
                context.getBaseContext().getResources().getDisplayMetrics());
    }
}
