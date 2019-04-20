package com.project_n.testlistretrofit.View.Main;

import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Model.HistoryItem;
import com.project_n.testlistretrofit.Presenter.HistoryPresenter;
import com.project_n.testlistretrofit.Presenter.PlayerPresenterImpl;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Adpter.RV_AdapterPlayer;
import com.project_n.testlistretrofit.View.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements MainView {

    private AppCompatDialog dialog;
    private RecyclerView mRvPlayer;
    private RV_AdapterPlayer rv_adapterPlayer;
    private List<History> mHistories = new ArrayList<>();
    private PlayerPresenterImpl playerPresenterImpl;
    private HistoryPresenter historyPresenter;
    private TextView klub;


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

        rv_adapterPlayer.setOnCallbackListener(new RV_AdapterPlayer.OnCallbackListener() {
            @Override
            public void onClick(History history) {
                showDialogDetail(history);
            }
        });
    }

    @Override
    public void historyReady(List<History> Histories) {
        mHistories.addAll(Histories);
        rv_adapterPlayer.setdata(Histories );
        rv_adapterPlayer.notifyDataSetChanged();
////        for (History history : Histories) {
////            Log.i("RETROFIT", history.getId() + "\n"
////                    + " - team:  " + history.getTeam() + " \n"
////                    + " - nama: " + history.getNama());
////        }
    }

    public void showDialogDetail(final History HistoryhistoryItem) {
        dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.item_history);
        dialog.setTitle("");
        List<HistoryItem> historyItems = HistoryhistoryItem.getHistory();
        final TextView klub = dialog.findViewById(R.id.tv_club);
        klub.setText(historyItems.get(0).getKlub());

        final Button btnOK = dialog.findViewById(R.id.btn_OK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


}
