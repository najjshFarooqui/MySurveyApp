package com.example.administrator.retroitfetchdata.network.auth;

import com.example.administrator.retroitfetchdata.network.country.LoginRequest;
import com.example.administrator.retroitfetchdata.network.country.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest request);
}
