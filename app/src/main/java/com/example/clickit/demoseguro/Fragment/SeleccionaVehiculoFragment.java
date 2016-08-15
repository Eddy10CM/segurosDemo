package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 11/08/16.
 */
public class SeleccionaVehiculoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button btnCotizar;

    public SeleccionaVehiculoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selecciona_vehiculo,container,false);
        Spinner spinnerSeguros = (Spinner)view.findViewById(R.id.spinner_seguros);

        btnCotizar = (Button)view.findViewById(R.id.btnCotizar);

        spinnerSeguros.setOnItemSelectedListener(this);

        Spinner spinnerAutos = (Spinner)view.findViewById(R.id.autos);
        Spinner spinnerEdad = (Spinner)view.findViewById(R.id.edad);

        List<String> autos = new ArrayList<>();
        autos.add("Golf Gti 2015");
        autos.add("Honda City 2015");
        autos.add("Mazda 2015");

        List<String> seguros = new ArrayList<>();
        seguros.add("Autos");

        List<String> edad = new ArrayList<>();
        edad.add("Edad");
        edad.add("18");
        edad.add("19");
        edad.add("20");
        edad.add("21");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, seguros);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSeguros.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapterAutos = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,autos);
        dataAdapterAutos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAutos.setAdapter(dataAdapterAutos);

        ArrayAdapter<String> dataAdapterEdad = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,edad);
        dataAdapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdad.setAdapter(dataAdapterEdad);

        btnCotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(position).toString();
        Log.e("TAG",adapterView.toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
