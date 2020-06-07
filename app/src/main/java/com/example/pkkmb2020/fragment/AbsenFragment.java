package com.example.pkkmb2020.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pkkmb2020.R;

public class AbsenFragment extends Fragment {

    View v;
    Context thiscontext;
    Dialog dialog;
    private ImageView img, back;


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_absen, container,false);
        thiscontext = container.getContext();
        img = v.findViewById(R.id.imageQR);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydialaog();
            }
        });
        return v;
    }

    public void Mydialaog(){
        dialog = new Dialog(thiscontext);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }
}
