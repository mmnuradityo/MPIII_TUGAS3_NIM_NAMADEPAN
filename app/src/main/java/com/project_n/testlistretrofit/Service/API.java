package com.project_n.testlistretrofit.Service;

import com.project_n.testlistretrofit.Model.ResponseApiHistory;
import com.project_n.testlistretrofit.Model.ResponseApiPlayer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("player")
    Call<ResponseApiPlayer> getPlayer();

    @GET("history")
    Call<ResponseApiHistory> getHistory();

}
