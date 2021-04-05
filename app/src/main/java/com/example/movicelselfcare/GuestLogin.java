package com.example.movicelselfcare;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.regex.Pattern;

public class GuestLogin extends AppCompatActivity {

    private EditText edtPhone;
    private ImageView goBack;
    private Button btnContinue;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_login);

        edtPhone = findViewById(R.id.number);
        btnContinue = findViewById(R.id.next);
        goBack = findViewById(R.id.goBack);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.red));

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidPjhone(edtPhone.getText().toString())) {

                    LoginActivity.fa.finish();
                    finish();
                    Intent intent = new Intent(GuestLogin.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    edtPhone.setError(getString(R.string.phoneErr));
                    edtPhone.requestFocus();
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        edtPhone.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                edtPhone.setError(null);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private boolean isValidPjhone(String phone) {

        String PHONE_STRING = "[0-9]{9}";

        return Pattern.compile(PHONE_STRING).matcher(phone).matches();

    }
}
