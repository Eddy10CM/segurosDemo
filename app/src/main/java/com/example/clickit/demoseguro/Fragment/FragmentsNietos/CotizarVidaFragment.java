package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by clickit on 29/08/16.
 */
public class CotizarVidaFragment extends Fragment {

    Spinner spinnervida;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        List<String> data1 = new ArrayList<>();
        data1.add("Seleccione");
        data1.add("Error de captura");
        data1.add("Baja de unidad");
        data1.add("Perdida Total/Robo de la unidad");
        data1.add("Unidad ya asegurada(Duplicada)");
        data1.add("Cambio de cobertura");
        data1.add("Cambio de aseguradora");

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,data1);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        years.add("Edad");
        for (int i = 18; i <= 69; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, years);

        /*Spinner spinYear = (Spinner)findViewById(R.id.yearspin);
        spinYear.setAdapter(adapter);*/


/*
ArrayList<String> years = new ArrayList<String>();
int thisYear = Calendar.getInstance().get(Calendar.YEAR);
for (int i = 1900; i <= thisYear; i++) {
    years.add(Integer.toString(i));
}
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

Spinner spinYear = (Spinner)findViewById(R.id.yearspin);
spinYear.setAdapter(adapter);
*/


        View view = inflater.inflate(R.layout.fragment_cotiza_vida,container,false);

        spinnervida = (Spinner) view.findViewById(R.id.edadvida);
        spinnervida.setAdapter(adapter);
        return view;


    }
}
