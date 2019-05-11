package com.project_n.testlistretrofit.View.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Presenter.Main.HistoryPresenter;
import com.project_n.testlistretrofit.Presenter.Main.PlayerPresenterImpl;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Adpter.RV_AdapterPlayer;
import com.project_n.testlistretrofit.View.Base.BaseActivity;
import com.project_n.testlistretrofit.utils.PreferencesHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements MainView {

    private RecyclerView mRvPlayer;
    private RV_AdapterPlayer rv_adapterPlayer;
    private List<History> mHistories = new ArrayList<>();
    private PlayerPresenterImpl playerPresenterImpl;
    private HistoryPresenter historyPresenter;
    private PreferencesHelper preferencesHelper;
    private TextView email;

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
        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());
    }

    @Override
    public void findView() {
        mRvPlayer = findViewById(R.id.rv_player);
        email = findViewById(R.id.tv_main_email);
    }

    @Override
    public void initView() {
        mRvPlayer.setLayoutManager(new LinearLayoutManager(this));
        rv_adapterPlayer = new RV_AdapterPlayer(this);
        mRvPlayer.setAdapter(rv_adapterPlayer);
        email.setText(preferencesHelper.getName());
    }

    @Override
    public void historyReady(List<History> Histories) {
        mHistories.addAll(Histories);
        rv_adapterPlayer.setdata(Histories );
        rv_adapterPlayer.notifyDataSetChanged();
    }

}
