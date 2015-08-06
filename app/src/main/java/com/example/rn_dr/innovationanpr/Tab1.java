package com.example.rn_dr.innovationanpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rn_dr.innovationanpr.R;

public class Tab1 extends Fragment {
    Button btnaceptar;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_layout, container, false);
        btnaceptar = (Button) v.findViewById(R.id.btnAceptar);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), main_from_class.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
