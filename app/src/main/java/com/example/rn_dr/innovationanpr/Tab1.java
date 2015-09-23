package com.example.rn_dr.innovationanpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rn_dr.innovationanpr.R;

import java.util.Objects;

public class Tab1 extends Fragment {
    Button btnaceptar;
    EditText txtusuario;
    EditText txtcontraseña;
    String user="admin";
    String pass="123";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_layout, container, false);
        txtusuario = (EditText) v.findViewById(R.id.txtUser);
        txtcontraseña = (EditText) v.findViewById(R.id.txtPassword);
        btnaceptar = (Button) v.findViewById(R.id.btnAceptar);

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.i("Pruebalogggg",txtusuario.getText().toString());
                if(txtusuario.getText().toString().equals(user) && txtcontraseña.getText().toString().equals(pass)) {
                    Intent intent = new Intent(getActivity(), main_from_class.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), main_admin.class);
                    startActivity(intent);
                }

            }
        });
        return v;
    }
}
