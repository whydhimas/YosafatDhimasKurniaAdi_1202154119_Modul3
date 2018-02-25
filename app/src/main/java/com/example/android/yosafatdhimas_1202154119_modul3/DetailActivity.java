package com.example.android.yosafatdhimas_1202154119_modul3;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    //inisiasi variabel
    TextView mineralTitle, mineralLiter;
    ImageView mineralImage, mineralBattery;
    private int liters = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mineralTitle = (TextView)findViewById(R.id.titleDetail);
        mineralImage = (ImageView)findViewById(R.id.mineralImageDetail);
        mineralLiter = (TextView) findViewById(R.id.mineral_liter);
        mineralBattery = (ImageView) findViewById(R.id.battery);

        //get title dari intent yang dikirim tadi dan ditaruh ke TextView
        mineralTitle.setText(getIntent().getStringExtra("title"));
        //menggunakan Glide untuk memuat gambar ke dalam ImageView
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0)).into(mineralImage);
        Bottle();
    }

    //ketika button (-) di klik maka nilai liters akan berkurang
    public void onClickMin(View view) {
        liters--;
        Bottle();
    }

    //ketika button (+) di klik maka nilai liters akan berkurang
    public void onClickPlus(View view) {
        liters++;
        Bottle();
    }

    //ketika button (-)(+) diklik akan menjalankan fungsi percabangan if else
    public void Bottle(){
        if (liters <= 0 ){
            mineralLiter.setText("1L");
            mineralBattery.setImageResource(R.drawable.ic_battery_1);
            Toast.makeText(this,"Air sedikit", Toast.LENGTH_SHORT).show();
        } else if (liters == 1){
            mineralLiter.setText("2L");
            mineralBattery.setImageResource(R.drawable.ic_battery_2);
        } else if (liters == 2){
            mineralLiter.setText("3L");
            mineralBattery.setImageResource(R.drawable.ic_battery_3);
        } else if (liters == 3){
            mineralLiter.setText("4L");
            mineralBattery.setImageResource(R.drawable.ic_battery_4);
        } else if (liters == 4){
            mineralLiter.setText("5L");
            mineralBattery.setImageResource(R.drawable.ic_battery_5);
        } else {
            mineralLiter.setText("6L");
            mineralBattery.setImageResource(R.drawable.ic_battery_6);
            Toast.makeText(this,"Air sudah penuh", Toast.LENGTH_SHORT).show();
        }
    }
}
