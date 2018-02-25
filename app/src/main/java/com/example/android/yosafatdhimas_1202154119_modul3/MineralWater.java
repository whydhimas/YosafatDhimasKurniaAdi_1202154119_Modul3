package com.example.android.yosafatdhimas_1202154119_modul3;

/**
 * Created by Yosafat Dhimas on 24/02/2018.
 */

public class MineralWater {
    //membuat variabel yang mempresentasikan judul, deskripsi dan gambar tentang air mineral
    private String title;
    private String description;
    private final int imageResource;

    //constructor untuk air mineral data model
    MineralWater(String title, String description, int imageResource){
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    //get the judul dari air mineral
    String getTitle(){
        return title;
    }

    //get the description dari air mineral
    String getDescription(){
        return description;
    }

    //get the image dari resource air mineral
    public int getImageResource(){
        return imageResource;
    }
}
