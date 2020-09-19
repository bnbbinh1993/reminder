package com.example.reminder.ui.setting;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reminder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_setting, container, false);
        return view;
    }

}
