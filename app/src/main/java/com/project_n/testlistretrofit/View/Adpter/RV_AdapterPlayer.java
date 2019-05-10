package com.project_n.testlistretrofit.View.Adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Model.HistoryItem;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.DetailActivity;

import java.util.ArrayList;
import java.util.List;


public class RV_AdapterPlayer extends RecyclerView.Adapter<RV_AdapterPlayer.MyViewHolder> {

    private List<History> histories = new ArrayList<>();
    private Context context;
    private String setPosisis, setNama, setNegara, setTeam, setDesk, setNomor, setGambar, setUmur;

    public RV_AdapterPlayer(Context context) {
        this.context = context;
    }

    public void setdata(List<History> histories) {
        this.histories = histories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        History history = histories.get(position);
        setPosisis = history.getPosisi();
        setNama = history.getNama();
        setUmur = history.getAge();
        setNegara = history.getNegara();
        setTeam = history.getTeam();
        setNomor = history.getNomor();
        setDesk = history.getDeskripsi();
        setGambar = history.getGambar();
        final ArrayList<HistoryItem> historyItem = new ArrayList<>();
        historyItem.addAll(history.getHistory());

        myViewHolder.id.setText(setPosisis);
        myViewHolder.nama.setText(setNama);
        myViewHolder.team.setText(setUmur);

        Glide
                .with(context)
                .load(setGambar)
                .into(myViewHolder.imgProfile);

        myViewHolder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("posisi", setPosisis);
                b.putString("nama", setNama);
                b.putString("nomor", setNomor);
                b.putString("negara", setNegara);
                b.putString("team", setTeam);
                b.putString("umur", setUmur);
                b.putString("desk", setDesk);
                b.putString("gambar", setGambar);
                b.putParcelableArrayList("item",  historyItem);
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtras(b);
                context.startActivity(i);
                Toast.makeText(context, setNama, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView id, nama, team;
        private ImageView imgProfile;
        private CardView line;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            nama = itemView.findViewById(R.id.tv_nama);
            team = itemView.findViewById(R.id.tv_umur);
            imgProfile = itemView.findViewById(R.id.img_profile);
            line = itemView.findViewById(R.id.cv_Item);

        }
    }


}
