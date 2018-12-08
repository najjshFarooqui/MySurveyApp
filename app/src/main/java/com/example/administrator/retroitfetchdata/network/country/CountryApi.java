package com.example.administrator.retroitfetchdata.network.country;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApi {

    String baseUrl = "http://applligent.com/project/survey/api/";

    @GET("countries")
    Call<CountryResponse> getCountries();
}
