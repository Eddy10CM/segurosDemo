package com.example.clickit.demoseguro.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clickit.demoseguro.Adapters.AdaptadorSeguros;
import com.example.clickit.demoseguro.Adapters.AdaptadorSeguros1;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 11/08/16.
 */
public class CotizaFragment extends Fragment {

    private final String LOG_TAG = "test";
    String item,item1;
    RecyclerView recyclerView;
    AdaptadorSeguros adaptadorSeguros;
    AdaptadorSeguros1 adaptadorSeguros1;
    String auto="",edad="",sexo="",cp="";

    private LinearLayoutManager linearLayout;

    public CotizaFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v(LOG_TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOG_TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.list_seguros);
        linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);

        Spinner paquete = (Spinner)view.findViewById(R.id.paq);
        Spinner formPago = (Spinner)view.findViewById(R.id.form_pay);

        List<String> paquetes = new ArrayList<>();
        paquetes.add("Amplia");
        paquetes.add("Limitada");
        paquetes.add("RC");
        paquetes.add("Integral");

        List<String> formasDePago = new ArrayList<>();
        formasDePago.add("Completo");
        formasDePago.add("Semestral");
        formasDePago.add("Trimestral");

        paquete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item = adapterView.getItemAtPosition(position).toString();
                adaptadorSeguros = new AdaptadorSeguros();
                recyclerView.setAdapter(adaptadorSeguros);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        formPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item1 = adapterView.getItemAtPosition(position).toString();
                adaptadorSeguros1 = new AdaptadorSeguros1();
                recyclerView.setAdapter(adaptadorSeguros1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        ArrayAdapter<String> dataPaquetes = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,paquetes);
        dataPaquetes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paquete.setAdapter(dataPaquetes);

        ArrayAdapter<String> dataFormasPago = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,formasDePago);
        dataFormasPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formPago.setAdapter(dataFormasPago);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(LOG_TAG, "onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.v(LOG_TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(LOG_TAG, "onStart");
        /*if (auto.equals("")||edad.equals("")||sexo.equals("")||cp.equals("")){
            Log.e("Tag","Campos Vacios");
        }else{
            Log.e("TAG","Datos Capturados");
        }*/
    }

    @Override
    public void onResume () {
        super.onResume();
        Log.v(LOG_TAG, "onResume");
    }

    @Override
    public void onPause () {
        super.onPause();
        Log.v(LOG_TAG, "onPause");
    }

    @Override
    public void onStop () {
        super.onStop();
        Log.v(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        Log.v(LOG_TAG, "onDestroyView");
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        Log.v(LOG_TAG, "onDestroy");
    }

    @Override
    public void onDetach () {
        super.onDetach();
        Log.v(LOG_TAG, "onDetach");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * Shared preferences
         *
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String test = preferences.getString(SeleccionaVehiculoFragment.AUTOS,"");
        Log.e("TAG",test);
        Log.e("TAGG",SeleccionaVehiculoFragment.AUTOS);
        /******************************************************************************************************/
    }



    public void enviarDatos(String item, String item1, String item2, String item4) {
        Log.e("TAG",item+item1+item2+item4);
        auto = item;
        edad = item1;
        sexo = item2;
        cp = item4;
    }
}
