package com.example.administrator.retroitfetchdata.history;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HistoryApi {
    @POST("survey-history")
    Call<HistoryResponse> historyResponse(@Body HistoryRequest request);

}
