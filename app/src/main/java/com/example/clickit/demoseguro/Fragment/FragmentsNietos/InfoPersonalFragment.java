package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 23/08/16.
 */
public class InfoPersonalFragment extends Fragment {

    RadioButton radioPerFisica,radioPerMoral;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_personal,container,false);

        radioPerFisica = (RadioButton)view.findViewById(R.id.rad_fisica);
        radioPerMoral = (RadioButton)view.findViewById(R.id.rad_moral);
        return view;
    }
}
