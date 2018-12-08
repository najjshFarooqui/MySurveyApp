package com.example.administrator.retroitfetchdata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.history.HistoryResponse;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void onHistoryLoaded(HistoryResponse response) {
        Toast.makeText(getApplicationContext(), "Got result!", Toast.LENGTH_SHORT).show();
    }
}
