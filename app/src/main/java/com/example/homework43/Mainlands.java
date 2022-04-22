package com.example.homework43;

import android.graphics.drawable.Drawable;

public class Mainlands {
    private String name;
    private String capital;
    private int image;

    public Mainlands(String name,String capital,int image) {
        this.name = name;
        this.capital = capital;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
