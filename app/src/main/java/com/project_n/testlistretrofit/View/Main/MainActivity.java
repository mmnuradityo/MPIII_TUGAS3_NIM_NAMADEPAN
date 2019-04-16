package com.project_n.testlistretrofit.View.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Model.Player;
import com.project_n.testlistretrofit.Presenter.HistoryPresenter;
import com.project_n.testlistretrofit.Presenter.PlayerPresenterImpl;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Adpter.RV_AdapterPlayer;
import com.project_n.testlistretrofit.View.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    private RecyclerView mRvPlayer;
    private RV_AdapterPlayer rv_adapterPlayer;
    private List<Player> mPlayer = new ArrayList<>();
    private PlayerPresenterImpl playerPresenterImpl;
    private HistoryPresenter historyPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponents() {
        playerPresenterImpl = new PlayerPresenterImpl(this);
        historyPresenter = new HistoryPresenter(this);
        playerPresenterImpl.getData();
        historyPresenter.getData();
    }

    @Override
    public void findView() {
        mRvPlayer = findViewById(R.id.rv_player);
    }

    @Override
    public void initView() {

        mRvPlayer.setLayoutManager(new LinearLayoutManager(this));
        rv_adapterPlayer = new RV_AdapterPlayer(this);
        mRvPlayer.setAdapter(rv_adapterPlayer);
    }


    @Override
    public void playerReady(List<Player> players) {
        mPlayer.addAll(players);
        rv_adapterPlayer.setdata(mPlayer);
        rv_adapterPlayer.notifyDataSetChanged();

//        for (Player player : players) {
//            Log.i("RETROFIT", player.getId() + "\n"
//                    + " - team:  " + player.getTeam() + " \n"
//                    + " - nama: " + player.getNama());
//        }

    }

    @Override
    public void historyReady(List<History> Histories) {
////        for (History history : Histories) {
////            Log.i("RETROFIT", history.getId() + "\n"
////                    + " - team:  " + history.getTeam() + " \n"
////                    + " - nama: " + history.getNama());
////        }
    }

}
