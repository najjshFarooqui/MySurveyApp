package com.example.administrator.retroitfetchdata.network.submit;

import com.example.administrator.retroitfetchdata.helper.Constant;
import com.example.administrator.retroitfetchdata.view.activity.SurveyActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitApiService {

    SurveyActivity surveyActivity;

    public SubmitApiService(SurveyActivity surveyActivity) {
        this.surveyActivity = surveyActivity;
    }

    private SubmitApi getSubmitApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SubmitApi.class);
    }

    public void submitResult(final SubmitRequest request) {
        Call<SubmitResponse> response = getSubmitApi().submitResult(request);
        response.enqueue(new Callback<SubmitResponse>() {
            @Override
            public void onResponse(Call<SubmitResponse> call, Response<SubmitResponse> response) {
                if (response.body() == null) {
                    surveyActivity.onOptionSubmitted(getSubmitFailedResponse());
                } else
                    surveyActivity.onOptionSubmitted(response.body());
            }

            @Override
            public void onFailure(Call<SubmitResponse> call, Throwable t) {
                surveyActivity.onOptionSubmitted(getSubmitFailedResponse());
            }
        });
    }

    private SubmitResponse getSubmitFailedResponse() {
        SubmitResponse response = new SubmitResponse();
        response.success = false;
        response.message = "Something went wrong!";
        return response;
    }
}
