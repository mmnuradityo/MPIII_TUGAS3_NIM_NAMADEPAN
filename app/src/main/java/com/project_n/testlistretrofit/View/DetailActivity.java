package com.project_n.testlistretrofit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Presenter.HistoryPresenter;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Main.MainView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private String idPemain, setNama;
    private TextView id, nama, team;
    private ImageView imgProfile;
    private HistoryPresenter historyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        idPemain = i.getExtras().getString("id");
        setNama = i.getExtras().getString("nama");

        findView();
        initView();
    }

    private void findView() {
//        id = findViewById(R.id.tv_detail);
        nama = findViewById(R.id.tv_detail_nama);
//        team = findViewById(R.id.tv_umur);
//        imgProfile = findViewById(R.id.img_profile);
    }

    private void initView() {
        nama.setText(setNama);
    }

}

