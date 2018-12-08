package com.example.administrator.retroitfetchdata.network.submit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SubmitApi {

    @POST("submit")
    Call<SubmitResponse> submitResult(@Body SubmitRequest request);

}
