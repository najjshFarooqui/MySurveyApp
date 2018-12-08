package com.example.administrator.retroitfetchdata.history;

import com.example.administrator.retroitfetchdata.helper.Constant;
import com.example.administrator.retroitfetchdata.view.activity.HistoryActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HIstoryApiService {
    HistoryActivity historyActivity;

    public HIstoryApiService(HistoryActivity historyActivity) {
        this.historyActivity = historyActivity;
    }

    private HistoryApi getHistoryApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HistoryApi.class);
    }

    public void loadHistory(final HistoryRequest request) {
        final Call<HistoryResponse> historyResponse = getHistoryApi().historyResponse(request);
        historyResponse.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (response.body() == null) {
                    historyActivity.onHistoryLoaded(getResultFailedResponse());
                } else
                    historyActivity.onHistoryLoaded(response.body());
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {

                historyActivity.onHistoryLoaded(getResultFailedResponse());

            }
        });
    }


    private HistoryResponse getResultFailedResponse() {
        HistoryResponse response = new HistoryResponse();
        response.success = false;
        response.message = "Something went wrong!";
        return response;
    }

}
