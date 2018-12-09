package com.example.administrator.retroitfetchdata;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.retroitfetchdata.preference.AuthPreference;
import com.example.administrator.retroitfetchdata.view.activity.HistoryActivity;
import com.example.administrator.retroitfetchdata.view.activity.SurveyActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent intent;
                if (AuthPreference.isUserLoggedIn(getApplicationContext()))
                    intent = new Intent(getApplicationContext(), SurveyActivity.class);
                else
                    intent = new Intent(SplashActivity.this, AuthActivity.class);*/
                Intent intent = new Intent(SplashActivity.this, HistoryActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}
