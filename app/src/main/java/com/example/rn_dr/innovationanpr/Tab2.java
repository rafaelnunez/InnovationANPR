package com.example.rn_dr.innovationanpr;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.protocol.ExecutionContext;

import java.util.concurrent.ExecutionException;


public class Tab2 extends Fragment {

    Context thiscontext;
    EditText txtusuarior;
    EditText txtcontraseñar;
    EditText txtemailr;
    EditText txtConfirmarcontraseñar;
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        thiscontext = container.getContext();
        View v = inflater.inflate(R.layout.regis_entity_layout, container, false);
        Button btnsiguiente = (Button) v.findViewById(R.id.btnSiguiente);
        final RegistrosadminDTO Reg = new RegistrosadminDTO();
        txtusuarior = (EditText) v.findViewById(R.id.txtUserr);
        txtcontraseñar = (EditText) v.findViewById(R.id.txtPasswordr);
        txtConfirmarcontraseñar = (EditText) v.findViewById(R.id.txtConfirmarContraseña);
        txtemailr = (EditText) v.findViewById(R.id.txtCorreor);

        final Gson gsson;
        gsson = new Gson();

        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!verificaConexion(thiscontext)) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Comprueba tu conexión a Internet.", Toast.LENGTH_SHORT)
                            .show();
                }else {


                    String Res = new String();
                    if (validarClave(txtcontraseñar.getText().toString(),txtConfirmarcontraseñar.getText().toString())==true){
                        Reg.setUsuario(txtusuarior.getText().toString());
                        Reg.setPassword(txtcontraseñar.getText().toString());
                        Reg.setEmail(txtemailr.getText().toString());
                        Reg.setRoles_idRoles("1");
                        Res = gsson.toJson(Reg);
                        PostAsyncrona Regs = new PostAsyncrona(Res);
                        /*Reg.SetContext(MainActivity.this);*/
                        String ban = null;
                        try {
                            ban = Regs.execute("http://190.109.185.138/ANPR/api/Usuarios").get();
                            Verificacion(ban);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }
        });
        return v;
    }

    private Boolean validarClave(String clave,String reclave){
        Boolean validar=true;
        if (clave.equals(reclave) == false){
            validar = false;
            Toast.makeText(getActivity().getApplication(),"La clave no coincide",
                    Toast.LENGTH_SHORT).show();
        }
        return validar;
    }

    private void Verificacion(String ban){
        String val1= "\"OK\"";
        String val3="\"YR\"";

        if (ban.equals(val3)){
            Toast.makeText(getActivity().getApplication(),"El Usuario se encuentra registrado",
                    Toast.LENGTH_SHORT).show();

        }else {

            Toast.makeText(getActivity().getApplication(),"Usuario registrado Exitosamente",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity().getApplicationContext(), registra_parqueadero.class);
            startActivity(intent);
        }

    }

    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

}



