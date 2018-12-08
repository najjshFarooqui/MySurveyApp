package com.example.administrator.retroitfetchdata.network.survey;

import com.example.administrator.retroitfetchdata.helper.Constant;
import com.example.administrator.retroitfetchdata.view.activity.SurveyActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SurveyApiService {

    SurveyActivity surveyActivity;

    public SurveyApiService(SurveyActivity surveyActivity) {
        this.surveyActivity = surveyActivity;
    }

    private SurveyApi getSurveyApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SurveyApi.class);
    }


    public void loadSurvey(final SurveyRequest request) {
        Call<SurveyResponse> response = getSurveyApi().getSurvey(request);
        response.enqueue(new Callback<SurveyResponse>() {
            @Override
            public void onResponse(Call<SurveyResponse> call, Response<SurveyResponse> response) {
                if (response.body() == null) {
                    surveyActivity.onSurveyLoaded(getSurveyFailedResponse());
                } else
                    surveyActivity.onSurveyLoaded(response.body());
            }

            @Override
            public void onFailure(Call<SurveyResponse> call, Throwable t) {

                surveyActivity.onSurveyLoaded(getSurveyFailedResponse());

            }
        });
    }

    private SurveyResponse getSurveyFailedResponse() {
        SurveyResponse response = new SurveyResponse();
        response.success = false;
        return response;
    }
}



