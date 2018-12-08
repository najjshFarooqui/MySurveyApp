package com.example.administrator.retroitfetchdata.network.survey;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SurveyApi {
    @POST("survey")
    Call<SurveyResponse> getSurvey(@Body SurveyRequest request);


}
