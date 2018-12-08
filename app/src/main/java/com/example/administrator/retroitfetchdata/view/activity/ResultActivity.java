package com.example.administrator.retroitfetchdata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.network.result.ResultResponse;
import com.example.administrator.retroitfetchdata.network.result.ResultServiceApi;

public class ResultActivity extends AppCompatActivity {
    ResultServiceApi resultServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
    }

    public void onResultLoaded(ResultResponse response) {
        Toast.makeText(getApplicationContext(), "Got result!", Toast.LENGTH_SHORT).show();
    }
}
