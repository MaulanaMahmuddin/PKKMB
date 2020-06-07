package com.example.pkkmb2020.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pkkmb2020.R;
import com.example.pkkmb2020.adapter.Beranda;
import com.example.pkkmb2020.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BeradaFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<Beranda> mData;

    public BeradaFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_beranda,container,false);
        recyclerView = v.findViewById(R.id.rv_beranda);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),mData);
        RecyclerView.LayoutManager mlayoutmanager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(mlayoutmanager);
        recyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mData = new ArrayList<>();
        mData.add(new Beranda("Unduh Roundown",R.drawable.check));
        mData.add(new Beranda("Mars & Hymne UBP", R.drawable.hymne));
        mData.add(new Beranda("Dokumen PKKMB", R.drawable.doc));
    }
}
