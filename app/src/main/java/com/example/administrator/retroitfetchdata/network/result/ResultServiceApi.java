package com.example.administrator.retroitfetchdata.network.result;

import com.example.administrator.retroitfetchdata.helper.Constant;
import com.example.administrator.retroitfetchdata.view.activity.ResultActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultServiceApi {
    ResultActivity resultActivity;

    public ResultServiceApi(ResultActivity resultActivity) {
        this.resultActivity = resultActivity;
    }

    private ResultApi getResultApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ResultApi.class);
    }

    public void loadResult(final ResultRequest request) {
        Call<ResultResponse> resultResponse = getResultApi().resultResponse(request);
        resultResponse.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                if (response.body() == null) {
                    resultActivity.onResultLoaded(getResultFailedResponse());
                } else
                    resultActivity.onResultLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {

                resultActivity.onResultLoaded(getResultFailedResponse());

            }
        });
    }


    private ResultResponse getResultFailedResponse() {
        ResultResponse response = new ResultResponse();
        response.success = false;
        response.message = "Something went wrong!";
        return response;
    }
}
