package com.example.reminder.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Binh {
    public static final String TAG = "BNB";
    private Context context;
    private SharedPreferences preferences;

    public Binh(Context context) {
        this.context = context;
    }

    public void SaveInt(String name, int gt){
        preferences = context.getSharedPreferences("HIHI",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(name,gt);
        editor.apply();

    }
    public int getDataInt(String name){
        preferences = context.getSharedPreferences("HIHI",MODE_PRIVATE);
        int result = preferences.getInt(name, 0);
        return result;
    }
    public void SaveString(String name,String gt){
        preferences = context.getSharedPreferences("HIHI",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name,gt);
        editor.apply();
    }
    public String getDataString(String name,String er){
        preferences = context.getSharedPreferences("HIHI",MODE_PRIVATE);
         String result = preferences.getString(name, er);
        return result;
    }
}
