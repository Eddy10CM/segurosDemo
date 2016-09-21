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
import android.view.Gravity;
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
import com.example.clickit.demoseguro.Clases.ListaSeguros;
import com.example.clickit.demoseguro.Clases.MyCustomToast;
import com.example.clickit.demoseguro.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by clickit on 11/08/16.
 */
public class CotizaFragment extends Fragment {

    private final String LOG_TAG = "test";
    private String [] amplia;
    private String [] limitada;
    private String [] rc;
    private String [] integral;
    public static final String NOHAYDATOS  = "no hay datos";
    private ArrayList<ListaSeguros> seguros = new ArrayList<>();
    String item,item1;
    RecyclerView recyclerView;
    AdaptadorSeguros adaptadorSeguros;
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
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.list_seguros);
        linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);

        Spinner paquete = (Spinner)view.findViewById(R.id.paq);
        Spinner formPago = (Spinner)view.findViewById(R.id.form_pay);
        adaptadorSeguros = new AdaptadorSeguros(getActivity());
        recyclerView.setAdapter(adaptadorSeguros);

        amplia = getActivity().getResources().getStringArray(R.array.amplia);
        limitada = getActivity().getResources().getStringArray(R.array.limitada);
        rc = getActivity().getResources().getStringArray(R.array.rc);
        integral = getActivity().getResources().getStringArray(R.array.integral);

        List<String> paquetes = new ArrayList<>();
        paquetes.add("Amplia");
        paquetes.add("Limitada");
        paquetes.add("RC");
        paquetes.add("Integral");

        List<String> formasDePago = new ArrayList<>();
        formasDePago.add("Contado");
        formasDePago.add("Mensual");

        for (int i = 0; i<amplia.length; i++){
            ListaSeguros seg = new ListaSeguros();
            seg.setCosto(amplia[i]);
            seguros.add(seg);
        }
        adaptadorSeguros.setItems(seguros);

        paquete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item = adapterView.getItemAtPosition(position).toString();
                switch (position){
                    case 0:
                        adaptadorSeguros.clear();
                        for (int i = 0; i<amplia.length; i++){
                            ListaSeguros seg = new ListaSeguros();
                            seg.setCosto(amplia[i]);
                            seguros.add(seg);
                        }
                        adaptadorSeguros.setItems(seguros);
                        break;
                    case 1:
                        adaptadorSeguros.clear();
                        for (int i = 0; i<limitada.length; i++){
                            ListaSeguros seg = new ListaSeguros();
                            seg.setCosto(limitada[i]);
                            seguros.add(seg);
                        }
                        adaptadorSeguros.setItems(seguros);
                        break;
                    case 2:
                        adaptadorSeguros.clear();
                        for (int i = 0; i<rc.length; i++){
                            ListaSeguros seg = new ListaSeguros();
                            seg.setCosto(rc[i]);
                            seguros.add(seg);
                        }
                        adaptadorSeguros.setItems(seguros);
                        break;
                    case 3:
                        adaptadorSeguros.clear();
                        for (int i = 0; i<integral.length; i++){
                            ListaSeguros seg = new ListaSeguros();
                            seg.setCosto(integral[i]);
                            seguros.add(seg);
                        }
                        if (integral.length == 0){
                            MyCustomToast toast = new MyCustomToast(getActivity().getApplicationContext(),Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,50);
                            toast.show("Este paquete no se encuentra disponible");
                        }
                        adaptadorSeguros.setItems(seguros);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        item = paquetes.get(0).toString();
        item1 = formasDePago.get(0).toString();
        //item1 = formPago.getItemAtPosition(0).toString();

        formPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item1 = adapterView.getItemAtPosition(position).toString();
                //adaptadorSeguros = new AdaptadorSeguros(item1);
                //adaptadorSeguros.recibe(item1);
                //recyclerView.setAdapter(adaptadorSeguros);
                //enviarFormaPago(item1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        //mostrar(item,item1);


        ArrayAdapter<String> dataPaquetes = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,paquetes);
        dataPaquetes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paquete.setAdapter(dataPaquetes);

        ArrayAdapter<String> dataFormasPago = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,formasDePago);
        dataFormasPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formPago.setAdapter(dataFormasPago);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(new Date());
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int Month = now.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR);
        Month+=1;
        Log.e("TAG", fecha);
        Log.e("TAG", String.valueOf(day + "/" + Month + "/" + year));
        return view;
    }

    /*private void enviarPaquete(String item) {
        AdaptadorSeguros.Datos.recibirPaquete(item);
    }
    private void enviarFormaPago(String item1) {
        AdaptadorSeguros.Datos.recibirFormaPago(item1);
    }*/

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
