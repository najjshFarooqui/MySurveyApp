package com.example.administrator.retroitfetchdata.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.network.submit.SubmitApiService;
import com.example.administrator.retroitfetchdata.network.submit.SubmitRequest;
import com.example.administrator.retroitfetchdata.network.submit.SubmitResponse;
import com.example.administrator.retroitfetchdata.network.survey.Survey;
import com.example.administrator.retroitfetchdata.network.survey.SurveyApiService;
import com.example.administrator.retroitfetchdata.network.survey.SurveyRequest;
import com.example.administrator.retroitfetchdata.network.survey.SurveyResponse;
import com.example.administrator.retroitfetchdata.preference.AuthPreference;
import com.example.administrator.retroitfetchdata.view.adapter.SurveyOptionAdapter;

public class SurveyActivity extends AppCompatActivity {
    SurveyApiService surveyApiService;
    SubmitApiService submitApiService;
    RecyclerView recyclerView;
    Button submitButton;
    SurveyOptionAdapter surveyOptionAdapter;
    TextView questionLabel;
    Survey currSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        recyclerView = findViewById(R.id.recyclerView);
        questionLabel = findViewById(R.id.questionLabel);
        submitButton = findViewById(R.id.submitButton);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        surveyApiService = new SurveyApiService(SurveyActivity.this);
        submitApiService = new SubmitApiService(SurveyActivity.this);
        SurveyRequest request = new SurveyRequest();
        request.userId = 1;
        request.token = AuthPreference.getDeviceToken(getApplicationContext());
        request.page = 0;
        request.limit = 10;
        surveyApiService.loadSurvey(request);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = surveyOptionAdapter.selectedOption;
                if (selectedOption == -1)
                    Toast.makeText(getApplicationContext(), "Select an option", Toast.LENGTH_SHORT).show();
                else {
                    int options[] = new int[]{selectedOption};
                    SubmitRequest request = new SubmitRequest();
                    request.optionId = options;
                    request.token = AuthPreference.getDeviceToken(getApplicationContext());
                    request.surveyId = currSurvey.surveyId;
                    request.userId = 1;
                    submitApiService.submitResult(request);
                }
            }
        });
    }

    public void onSurveyLoaded(SurveyResponse response) {

        if (!response.success || response.survey.size() == 0) {
            Toast.makeText(getApplicationContext(), "Survey Not found", Toast.LENGTH_SHORT).show();
        } else {
            currSurvey = response.survey.get(0);
            questionLabel.setText(currSurvey.question);
            surveyOptionAdapter = new SurveyOptionAdapter(currSurvey.option);
            recyclerView.setAdapter(surveyOptionAdapter);
        }

    }

    public void onOptionSubmitted(SubmitResponse response) {

        if (!response.success) {
            Toast.makeText(getApplicationContext(), "Survey Not found", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(getApplicationContext(), ResultActivity.class));
        }

    }
}
