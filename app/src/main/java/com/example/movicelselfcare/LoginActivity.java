package com.example.movicelselfcare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText edtPassword, edtContact;
    private TextView createSignUp;
    private Button btnSignUp;
    private TextView guestLogin;
    public static Activity fa;
    String[] lan;
    private Button launguage;
    private Spinner launguageSpin;
    private CustomSharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = new CustomSharedPreferences(LoginActivity.this);

        fa = this;

        lan = getResources().getStringArray(R.array.launguage);

        edtPassword = findViewById(R.id.password);
        edtContact = findViewById(R.id.contactNo);
        btnSignUp = findViewById(R.id.signUp);
        createSignUp = findViewById(R.id.createsignUp);
        guestLogin = findViewById(R.id.guestsignUp);

        edtContact.setText("+244 ");
        Selection.setSelection(edtContact.getText(), edtContact.getText().length());

        edtContact.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().startsWith("+244 ")) {
                    edtContact.setText("+244 ");
                    Selection.setSelection(edtContact.getText(), edtContact.getText().length());
                }
            }
        });

        SpannableString spannableString = new SpannableString("  " + getResources().getString(R.string.signUp1));
        final ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(foregroundSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        createSignUp.append(spannableString);

        createSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        launguage = findViewById(R.id.launguage);

        if (sharedPreferences.getLanguage().equalsIgnoreCase("en")) {
            launguage.setText(getResources().getString(R.string.english));
        } else {
            launguage.setText(getResources().getString(R.string.portuguese));
        }

        launguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pum = new PopupMenu(LoginActivity.this, findViewById(R.id.launguage));
                if (sharedPreferences.getLanguage().equalsIgnoreCase("en")) {
                    pum.inflate(R.menu.menu_launguage);
                } else {
                    pum.inflate(R.menu.menu_launguage_pt);
                }
                pum.show();
                pum.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Locale myLocale;

                        Log.d("test", "ItemTitle : " + item.getTitle());
                        Log.d("test", "ItemToolTip : " + item.getTooltipText());
                        Log.d("test", "getLaund : " + sharedPreferences.getLanguage());
                        if (!item.getTooltipText().toString().equalsIgnoreCase(sharedPreferences.getLanguage())) {

                            if (item.getTitle().toString().equalsIgnoreCase(getResources().getString(R.string.portuguese))) {
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
                            //restart Activity
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                            overridePendingTransition(0, 0);
                        }
                        return false;
                    }
                });
            }
        });

        /*launguageSpin = findViewById(R.id.launguageSpin);

        launguageSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Locale myLocale;

                if (position == 0) {
                    myLocale = new Locale("pt", "AO");
                } else {
                    myLocale = new Locale("en", "US");
                }

                Locale.setDefault(myLocale);
                Configuration config = new Configuration();
                config.locale = myLocale;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                //restart Activity
                onRestart();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(LoginActivity.this, android.R.layout.simple_spinner_item, lan);
        launguageSpin.setAdapter(aa);*/

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtContact.getText().toString().length() == 14) {

                    if (edtPassword.getText().toString().equalsIgnoreCase("12345")) {

                        if (getIntent().hasExtra("guest")) {
                            setResult(101);
                            finish();
                        } else {
                            finish();
                            sharedPreferences.setGuestLogin(false);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        edtPassword.setError(getString(R.string.passErr));
                        edtPassword.requestFocus();
                    }
                } else {
                    edtContact.setError(getString(R.string.phoneErr));
                    edtContact.requestFocus();
                }
            }
        });

        guestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                sharedPreferences.setGuestLogin(true);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidPjhone(String phone) {

        String PHONE_STRING = "[0-9]{8}";

        return Pattern.compile(PHONE_STRING).matcher(phone).matches();

    }
}