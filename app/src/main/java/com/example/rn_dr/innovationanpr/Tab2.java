package com.example.rn_dr.innovationanpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Tab2 extends Fragment {
    private Button btnsiguie;
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.regis_entity_layout, container, false);
        btnsiguie = (Button) v.findViewById(R.id.btnSigui);
        btnsiguie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PreConfigEntity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}



