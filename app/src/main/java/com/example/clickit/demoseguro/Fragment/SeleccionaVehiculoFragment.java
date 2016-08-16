package com.example.clickit.demoseguro.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 11/08/16.
 */
public class SeleccionaVehiculoFragment extends Fragment /*implements AdapterView.OnItemSelectedListener*/ {

    private Button btnCotizar;
    public static final String AUTOS = "autos";
    public static final String EDAD = "edad";
    public static final String SEXO = "sexo";
    public static final String CP = "cp";
    String item="",item1="",item2="",item4;
    CotizaFragment cotizaFragment = new CotizaFragment();
    public SeleccionaVehiculoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selecciona_vehiculo,container,false);
        Spinner spinnerSeguros = (Spinner)view.findViewById(R.id.spinner_seguros);

        btnCotizar = (Button)view.findViewById(R.id.btnCotizar);



        Spinner spinnerAutos = (Spinner)view.findViewById(R.id.autos);
        Spinner spinnerEdad = (Spinner)view.findViewById(R.id.edad);
        Spinner spinnerSexo = (Spinner)view.findViewById(R.id.sexo);
        final TextView txtCP = (TextView)view.findViewById(R.id.cp);

        spinnerAutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item = adapterView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item1 = adapterView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item2 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


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

        List<String> sexo = new ArrayList<>();
        sexo.add("Hombre");
        sexo.add("Mujer");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, seguros);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSeguros.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapterAutos = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,autos);
        dataAdapterAutos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAutos.setAdapter(dataAdapterAutos);

        ArrayAdapter<String> dataAdapterEdad = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,edad);
        dataAdapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdad.setAdapter(dataAdapterEdad);

        ArrayAdapter<String> dataAdapterSexo = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,sexo);
        dataAdapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(dataAdapterSexo);

        btnCotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item1.equals("Edad")){
                    Log.e("TAG","Error debes seleccionar una edad");
                }else{
                    if (txtCP.getText().toString().equals("")){
                        Log.e("TAG","Error debes seleccionar una edad");
                    }else
                    {
                        item4 = txtCP.getText().toString().trim();
                        cotizaFragment.enviarDatos(item,item1,item2,item4);
                    }
                }
            }
        });
        return view;
    }

   /* @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}
