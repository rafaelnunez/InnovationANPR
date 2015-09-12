package com.example.rn_dr.innovationanpr;


import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * A simple {@link Fragment} subclass.
 */
public class fragment2_admin extends android.support.v4.app.Fragment {


    public fragment2_admin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2_admin, container, false);;
        ImageView ivAgregar = (ImageView) v.findViewById(R.id.ivAgregar);
        ivAgregar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                
            }
        });
        return inflater.inflate(R.layout.fragment_fragment2_admin, container, false);
    }


}
