package com.example.reminder.ui.setting;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.reminder.R;
import com.example.reminder.utils.Binh;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public static TextView signinId;
    public static TextView signoutId;
    public static CircleImageView iconuserId;
    private Binh binh = new Binh(getContext());


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        signinId = view.findViewById(R.id.signinId);
        signoutId = view.findViewById(R.id.signoutId);
        iconuserId = view.findViewById(R.id.iconuserId);

        initEvent();
        return view;
    }

    private void initEvent() {

        signinId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("DATA", 0);
                startActivity(intent);
            }
        });

        signoutId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("DATA", 1);
                startActivity(intent);

            }
        });


//       if (check){
//           signinId.setText(binh.getDataString("TEXTLOGIN","Sign in"));
//           signoutId.setText(binh.getDataString("TEXTLOGOUT","Log in to synv your data"));
//           Glide.with(getActivity())
//                   .load(binh.getDataString("URL_ICOM","url"))
//                   .error(R.drawable.ic_user)
//                   .into(iconuserId);
//       }
    }

    private void reset() {
        signinId.setText("Sign in");
        signoutId.setText("Log in to sync your data");
        Glide.with(getActivity())
                .load("hii")
                .error(R.drawable.ic_user)
                .into(iconuserId);
    }


}

