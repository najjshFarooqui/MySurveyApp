package com.example.administrator.retroitfetchdata.network.result;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ResultApi {
    @POST("results")
    Call<ResultResponse> resultResponse(@Body ResultRequest request);


}
