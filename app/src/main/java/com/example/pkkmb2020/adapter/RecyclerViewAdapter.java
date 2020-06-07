package com.example.pkkmb2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pkkmb2020.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mcontext;
    List<Beranda> mData;


    public RecyclerViewAdapter(Context mcontext, List<Beranda> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.item_menu,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.nama.setText(mData.get(position).getNama());
        holder.img.setImageResource(mData.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nama;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id.tv_title);
            img = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
