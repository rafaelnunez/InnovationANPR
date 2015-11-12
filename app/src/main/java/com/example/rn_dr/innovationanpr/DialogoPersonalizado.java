package com.example.rn_dr.innovationanpr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.example.rn_dr.innovationanpr.R;

public class DialogoPersonalizado extends DialogFragment {
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    builder.setView(inflater.inflate(R.layout.dialog_personal, null))
	           .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                   dialog.cancel();
	               }
	           });
	    
	    return builder.create();
    }
}
