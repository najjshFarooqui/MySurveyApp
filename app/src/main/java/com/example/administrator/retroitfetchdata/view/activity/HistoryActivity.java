package com.example.administrator.retroitfetchdata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.history.HistoryApiService;
import com.example.administrator.retroitfetchdata.history.HistoryRequest;
import com.example.administrator.retroitfetchdata.history.HistoryResponse.HistoryResponse;
import com.example.administrator.retroitfetchdata.view.adapter.HistoryAdapter;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HistoryApiService service;
    HistoryRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        service = new HistoryApiService(this);
        request = new HistoryRequest();
        request.userId=1;
        request.limit=10;
        request.page=0;
        request.token="1d37e12fa13ece4a3a80ba13f94956f8";

        service.loadHistory(request);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onHistoryLoaded(HistoryResponse response) {
        if (response.success)
            recyclerView.setAdapter(new HistoryAdapter(this, response.surveyHistory));
        else
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

    }
}
