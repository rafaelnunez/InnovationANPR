package com.example.rn_dr.innovationanpr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;


public class PreConfigEntity extends AppCompatActivity{
    private Button boton;
    private RadioButton rbPrivado;
    private RadioButton rbPublico;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_parqueadero);
            boton = (Button)findViewById(R.id.btnSigui);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), tipo_parqueadero.class);
                    startActivity(intent);
                }
            });
        }
    }

