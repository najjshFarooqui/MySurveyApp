package com.example.administrator.retroitfetchdata.network.country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProvienceApi {
    String baseUrl = "http://applligent.com/project/survey/api/";

    @GET("provience/{id}")
    Call<ProvienceResponse> getProvience(@Path("id") int id);
}
