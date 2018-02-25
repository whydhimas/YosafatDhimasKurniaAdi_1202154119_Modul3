package com.example.android.yosafatdhimas_1202154119_modul3;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {
    //membuat ukuran waktu tampilan pada splash
    private final int SPLASH_DISPLAY_LENGTH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //membuat delay waktu sampai yang ditentukan
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //membuat perpindahan dengan intent yang menuju ke MainActivity
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
