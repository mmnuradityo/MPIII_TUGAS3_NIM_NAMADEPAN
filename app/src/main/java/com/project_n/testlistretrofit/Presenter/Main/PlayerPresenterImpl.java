package com.project_n.testlistretrofit.Presenter.Main;

import com.project_n.testlistretrofit.Service.Service;
import com.project_n.testlistretrofit.View.Main.MainView;

public class PlayerPresenterImpl implements Presenter {

    private MainView mainView;
    private Service service;

    public PlayerPresenterImpl(MainView view) {
        this.mainView = view;

        if (this.service == null) {
            this.service = new Service();
        }
    }


    @Override
    public void getData() {
//        service
//                .getAPI()
//                .getPlayer()
//                .enqueue(new Callback<ResponseApiPlayer>() {
//                    @Override
//                    public void onResponse(Call<ResponseApiPlayer> call, Response<ResponseApiPlayer> response) {
//                        ResponseApiPlayer data = response.body();
//
//                        if (data != null && data.getData() != null) {
//                            List<Player> result = data.getData();
//                            mainView.playerReady(result);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseApiPlayer> call, Throwable t) {
//
//                    }
//
//
//                });
    }

}
