package com.example.android.yosafatdhimas_1202154119_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<MineralWater> mMineralData;
    private MineralWaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //melakukan set LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //inisiasi ArrayList yang nanti berisi data
        mMineralData = new ArrayList<>();

        //inisiasi adapter dan melakukan set ke RecyclerView
        mAdapter = new MineralWaterAdapter(this, mMineralData);
        mRecyclerView.setAdapter(mAdapter);

        //get data
        initialzeData();

        //mengambil integer dari file integers.xml
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        //mengubah LinearLayoutManager menjadi GridLayoutManager, melewati context dan integer yang baru dibuat
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    private void initialzeData() {
        //get resource dari file xml
        String[] mineralList = getResources().getStringArray(R.array.mineral_titles);
        String[] mineralDesc = getResources().getStringArray(R.array.mineral_descriptions);
        //get TypedArray dari id resource
        TypedArray mineralImageResources = getResources().obtainTypedArray(R.array.mineral_images);

        //menghapus data eksisting untuk menghindari duplikasi data
        mMineralData.clear();

        //membuat ArrayList dari objek Mineral dengan judul, deskripsi, dan gambar masing-masing air mineral
        for (int i =0; i<mineralList.length; i++){
            mMineralData.add(new MineralWater(mineralList[i], mineralDesc[i], mineralImageResources.getResourceId(i,0)));
        }
        //membersihkan data dalam typed array sekali yang dibuat di ArrayList
        mineralImageResources.recycle();

        //notifikasi prubahan adapter
        mAdapter.notifyDataSetChanged();
    }
}
