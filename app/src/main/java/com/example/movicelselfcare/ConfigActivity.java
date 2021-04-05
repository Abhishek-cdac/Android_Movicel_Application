package com.example.movicelselfcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class ConfigActivity extends AppCompatActivity {

    EditText organizationName;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_config);
        submit = findViewById(R.id.submit);
        organizationName = findViewById(R.id.organizationName);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (organizationName.getText().toString() != "") {
                    if (organizationName.getText().toString() == "movicel") {
//                        AppConstants.BASE_URL = "https://nt3.nectarinfotel.com/webservices/"
//
//                        val i = Intent(this @ConfigActivity,LoginActivity:: class.java)
//                        startActivity(i)
//                        finish()
                    } else if (organizationName.getText().toString() == "nectar") {
//                        AppConstants.BASE_URL = "https://nt3test.nectarinfotel.com/webservices/"
//
//                        val i = Intent(this @ConfigActivity,LoginActivity:: class.java)
//                        startActivity(i)
//                        finish()
                    } else {
                        organizationName.requestFocus();
                        organizationName.setError("enter correct organization name");
                        organizationName.setFocusable(true);
                    }
                } else {
                    organizationName.requestFocus();
                    organizationName.setError("enter organization name");
                    organizationName.setFocusable(true);
                }

            }
        });
        // This method will be executed once the timer is over
        // Start your app main activity
            /* Bundle b=getIntent().getExtras();
                if(b!=null)
                {
                    String aa=b.getString("click_action");
                    if (getIntent().hasExtra("click_action"))
                    {
                        Intent resultIntent = new Intent(getApplicationContext(), TicketDetailsActivity.class);
                        startActivity(resultIntent);
                    }
                }
                else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                }*/
    }
}
