package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 23/08/16.
 */
public class InfoPersonalFragment extends Fragment {

    RadioButton radioPerFisica,radioPerMoral;

    // This will get the radiogroup
    RadioGroup rGroup;
    // This will get the radiobutton in the radiogroup that is checked
    //RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_personal,container,false);

        radioPerFisica = (RadioButton)view.findViewById(R.id.rad_fisica);
        radioPerMoral = (RadioButton)view.findViewById(R.id.rad_moral);
        rGroup = (RadioGroup) view.findViewById(R.id.rad_tpersons);

        /*if(radioPerFisica.isChecked()){
            Log.e("chequed1","Chequeroni1");
        }else if(radioPerMoral.isChecked()){
            Log.e("chequed2","Chequeroni2");
        }*/

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rad_fisica) {
                    //do work when radioButton1 is active
                    Log.e("chequed1","Chequeroni1");

                } else  if (checkedId == R.id.rad_moral) {
                    //do work when radioButton2 is active
                    Log.e("chequed2","Chequeroni2");
                }

            }
        });

        return view;
    }
}
