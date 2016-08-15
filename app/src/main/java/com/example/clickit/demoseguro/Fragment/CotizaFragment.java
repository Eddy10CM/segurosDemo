package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
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
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 11/08/16.
 */
public class CotizaFragment extends Fragment {

    String item,item1;
    RecyclerView recyclerView;
    AdaptadorSeguros adaptadorSeguros;
    AdaptadorSeguros.Datos datos;

    private LinearLayoutManager linearLayout;

    public CotizaFragment(){}

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
                adaptadorSeguros.envioDatos(item);
                //datos.recibirDatos(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        formPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                item1 = adapterView.getItemAtPosition(position).toString();
                adaptadorSeguros.envioDatos(item1);
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

        adaptadorSeguros = new AdaptadorSeguros();
        recyclerView.setAdapter(adaptadorSeguros);
        return view;
    }
}
