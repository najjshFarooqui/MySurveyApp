package com.example.administrator.retroitfetchdata.network.country;

import android.widget.Toast;

import com.example.administrator.retroitfetchdata.Country;
import com.example.administrator.retroitfetchdata.SignUpActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryApiService {
    SignUpActivity signUpActivity;

    public CountryApiService(SignUpActivity activity) {
        this.signUpActivity = activity;
    }

    private CountryApi getCountryApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CountryApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CountryApi.class);
    }

    private ProvienceApi getProvienceApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ProvienceApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ProvienceApi.class);
    }

    public void loadCountries() {
        Call<CountryResponse> call = getCountryApi().getCountries();
        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse countryResponse = response.body();
                List<Country> countries = countryResponse.countries;
                signUpActivity.onCountryLoaded(countries);
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                Toast.makeText(signUpActivity, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void loadProviences(int id) {
        Call<ProvienceResponse> provienceResponseCall = getProvienceApi().getProvience(id);
        provienceResponseCall.enqueue(new Callback<ProvienceResponse>() {
            @Override
            public void onResponse(Call<ProvienceResponse> call, Response<ProvienceResponse> response) {
                ProvienceResponse response1 = response.body();
                List<Provience> provienceList = response1.provience;
                signUpActivity.onProvinceLoaded(provienceList);
            }

            @Override
            public void onFailure(Call<ProvienceResponse> call, Throwable t) {
            }
        });
    }
}
