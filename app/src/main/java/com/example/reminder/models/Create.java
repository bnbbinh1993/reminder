package com.example.reminder.models;

import android.widget.ImageView;

public class Create {
    private String text;
    private int image;

    public Create() {
    }

    public Create(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
