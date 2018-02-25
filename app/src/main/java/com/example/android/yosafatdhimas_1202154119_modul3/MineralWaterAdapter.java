package com.example.android.yosafatdhimas_1202154119_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Yosafat Dhimas on 24/02/2018.
 */

public class MineralWaterAdapter extends RecyclerView.Adapter<MineralWaterAdapter.ViewHolder> {
    //membuat variabel
    private ArrayList<MineralWater> mMineralData;
    private Context mContext;
    //membuat constructor
    MineralWaterAdapter(Context context, ArrayList<MineralWater> mineralData){
        this.mMineralData = mineralData;
        this.mContext = context;
    }

    @Override
    public MineralWaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MineralWaterAdapter.ViewHolder holder, int position) {
        //get currentMineral
        MineralWater currentMineral = mMineralData.get(position);
        //mengisi textview dengan data
        holder.bindTo(currentMineral);
        //menambahkan code Glide untuk mendapatkan image resource dari object mineral dan di load ke ImageView menggunakan Glide
        Glide.with(mContext).load(currentMineral.getImageResource()).into(holder.mMineralImage);
    }

    @Override
    public int getItemCount() {
        return mMineralData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //variabel untuk textveiw dan image
        private TextView mTitleText;
        private TextView mDescriptionsText;
        private ImageView mMineralImage;

        public ViewHolder(View itemView) {
            super(itemView);

            //inisiasi views
            mTitleText = (TextView) itemView.findViewById(R.id.title);
            mDescriptionsText = (TextView) itemView.findViewById(R.id.title_description);
            mMineralImage = (ImageView) itemView.findViewById(R.id.mineralImage);

            //menambahkan onClickListener ke ItemView di dalam constructor
            itemView.setOnClickListener(this);
        }

        public void bindTo(MineralWater currentMineral) {
            //mengisi textview dengan data
            mTitleText.setText(currentMineral.getTitle());
            mDescriptionsText.setText(currentMineral.getDescription());
        }

        @Override
        public void onClick(View view) {
            //get object mineral untuk item ketika diklik menggunakan getAdapterPosition()
            MineralWater currentMineral = mMineralData.get(getAdapterPosition());

            //membuat intent yang diaktifkan ke DetailActiviy, dan menaruh judul, dan gambar sebagai extras di intent
            Intent detailInt = new Intent(mContext, DetailActivity.class);
            detailInt.putExtra("title", currentMineral.getTitle());
            detailInt.putExtra("image_resource", currentMineral.getImageResource());

            //memanggil startActivity() mContext dan melewati intent baru
            mContext.startActivity(detailInt);
        }
    }
}
