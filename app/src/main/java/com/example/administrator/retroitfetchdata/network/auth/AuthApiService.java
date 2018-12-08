package com.example.administrator.retroitfetchdata.network.auth;

import com.example.administrator.retroitfetchdata.LoginActivity;
import com.example.administrator.retroitfetchdata.helper.Constant;
import com.example.administrator.retroitfetchdata.network.country.LoginRequest;
import com.example.administrator.retroitfetchdata.network.country.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthApiService {
    LoginActivity loginActivity;

    public AuthApiService(LoginActivity activity) {
        this.loginActivity = activity;
    }

    private AuthApi getAuthApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(AuthApi.class);
    }

    public void loginUser(final LoginRequest request) {
        Call<LoginResponse> response = getAuthApi().loginUser(request);
        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() == null) {
                    loginActivity.onUserLogin(getLoginFailedResponse());
                } else
                    loginActivity.onUserLogin(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                loginActivity.onUserLogin(getLoginFailedResponse());

            }
        });
    }

    private LoginResponse getLoginFailedResponse() {
        LoginResponse response = new LoginResponse();
        response.message = "Login Failed!";
        response.success = false;
        return response;
    }
}
