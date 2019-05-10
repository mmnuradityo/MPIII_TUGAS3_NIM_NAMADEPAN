package com.project_n.testlistretrofit.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project_n.testlistretrofit.Model.HistoryItem;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends BaseActivity {

    private TextView posisi, nama, negara, team, desk, nomor, umur;
    private ImageView imgProfile;
    private String setPosisis, setNama, setNegara, setTeam, setDesk, setNomor, setGambar, setUmur;
    private List<HistoryItem> historyItem = new ArrayList<>();
    private ListView LV_Item;

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public void initComponents() {
        getData();
    }

    @Override
    public void findView() {
        posisi = findViewById(R.id.tv_detail_posisi);
        nama = findViewById(R.id.tv_detail_nama);
        team = findViewById(R.id.tv_detail_Team);
        negara = findViewById(R.id.tv_detail_Neagra);
        desk = findViewById(R.id.tv_detail_desk);
        nomor = findViewById(R.id.tv_detail_Nomor);
        umur = findViewById(R.id.tv_detail_Umur);
        imgProfile = findViewById(R.id.img_Detail_profile);
        LV_Item = findViewById(R.id.lv_History);
        setImage();
    }

    @Override
    public void initView() {
        setData();
        initListView();
    }

    private void getData() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            setPosisis = b.getString("posisi");
            setNama = b.getString("nama");
            setNomor = b.getString("nomor");
            setNegara = b.getString("negara");
            setTeam = b.getString("team");
            setUmur = b.getString("umur");
            setDesk = b.getString("desk");
            setGambar = b.getString("gambar");
            historyItem = b.getParcelableArrayList("item");
        } else {
            Toast.makeText(this, "ada kesalahan", Toast.LENGTH_SHORT).show();
        }
    }

    private void setImage() {
        Glide
                .with(this)
                .load(setGambar)
                .into(imgProfile);
    }

    private void setData() {
        nama.setText(setNama);
        posisi.setText(setPosisis);
        team.setText(setTeam);
        negara.setText(setNegara);
        desk.setText(setDesk);
        nomor.setText(setNomor);
        umur.setText(setUmur);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListView() {
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, historyItem);
        LV_Item.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                view.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
                return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        LV_Item.setAdapter(adapter);
    }

}

