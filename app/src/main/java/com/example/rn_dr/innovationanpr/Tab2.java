package com.example.rn_dr.innovationanpr;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.rn_dr.innovationanpr.R;


public class Tab2 extends Fragment {
    private ImageButton btnSgt;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.regis_entity_layout,container,false);

        return v;
    }


}