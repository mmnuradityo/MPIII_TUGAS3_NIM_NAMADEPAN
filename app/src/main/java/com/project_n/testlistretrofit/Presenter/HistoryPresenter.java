package com.project_n.testlistretrofit.Presenter;

import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Model.ResponseApiHistory;
import com.project_n.testlistretrofit.Service.Service;
import com.project_n.testlistretrofit.View.Main.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter implements Presenter {

    private MainView mainView;
    private Service service;

    public HistoryPresenter(MainView view) {
        this.mainView = view;

        if (this.service == null) {
            this.service = new Service();
        }
    }

    @Override
    public void getData() {
        service
                .getAPI()
                .getHistory()
                .enqueue(new Callback<ResponseApiHistory>() {
                    @Override
                    public void onResponse(Call<ResponseApiHistory> call, Response<ResponseApiHistory> response) {
                        ResponseApiHistory data = response.body();

                        if (data != null && data.getData() != null) {
                            List<History> result = data.getData();
                            mainView.historyReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseApiHistory> call, Throwable t) {

                    }


                });
    }
}
