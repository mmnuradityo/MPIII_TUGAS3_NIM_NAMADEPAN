package com.project_n.testlistretrofit.View.Adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project_n.testlistretrofit.Model.History;
import com.project_n.testlistretrofit.Model.HistoryItem;
import com.project_n.testlistretrofit.R;

import java.util.ArrayList;
import java.util.List;


public class RV_AdapterPlayer extends RecyclerView.Adapter<RV_AdapterPlayer.MyViewHolder> {

    private List<History> histories = new ArrayList<>();
    private Context context;
    private OnCallbackListener listener;

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
        myViewHolder.id.setText(history.getPosisi());
        myViewHolder.nama.setText(history.getNama());
        myViewHolder.team.setText(history.getAge());

        Glide
                .with(context)
                .load(history.getGambar())
                .centerCrop()
                .into(myViewHolder.imgProfile);
    }


    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        private TextView id, nama, team;
        private ImageView imgProfile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            nama = itemView.findViewById(R.id.tv_nama);
            team = itemView.findViewById(R.id.tv_umur);
            imgProfile = itemView.findViewById(R.id.img_profile);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onClick(histories.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(History history);
    }


}
