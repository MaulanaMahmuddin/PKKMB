package com.example.pkkmb2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(), IntroScreen.class));
                            finish();
                        }
                    });
                }
            }
        }).start();
    }
}
