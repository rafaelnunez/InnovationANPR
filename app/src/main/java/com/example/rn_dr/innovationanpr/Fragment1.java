package com.example.rn_dr.innovationanpr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Fragment1 extends Fragment {
    public Fragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragment1, container, false);
        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.rbgroupregises);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.rbAutomovil:
                        Toast.makeText(getActivity(), "Automóvil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbMotocicleta:
                        Toast.makeText(getActivity(), "Motocicleta", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.rbBicicleta:
                        Toast.makeText(getActivity(), "Bicicleta", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return v;
    }
}
