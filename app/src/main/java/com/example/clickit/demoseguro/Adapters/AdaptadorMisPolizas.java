package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
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
 * Created by clickit on 14/08/16.
 */
public class AdaptadorMisPolizas extends RecyclerView.Adapter<AdaptadorMisPolizas.ViewHodlder> {


    Spinner quiero,motivo;
    ViewGroup linear;
    private static final int DURATION = 250;

    public class ViewHodlder extends RecyclerView.ViewHolder {
        public ViewHodlder(View itemView) {
            super(itemView);
        }
    }

    public AdaptadorMisPolizas() {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public ViewHodlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_polizas,parent,false);

        quiero = (Spinner)view.findViewById(R.id.quiero_polizas);
        motivo = (Spinner)view.findViewById(R.id.motivo);

        List<String> data = new ArrayList<>();
        data.add("Seleccione");
        data.add("Dar de baja");


        List<String> data1 = new ArrayList<>();
        data1.add("Seleccione");
        data1.add("Opcion 1");
        data1.add("Opcion 2");



        quiero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (item.equals("Seleccione")){
                    Log.e("TAG","No se ha seleccionado ninguna opcion");
                    ExpandAndCollapseViewUtil.collapse(linear, DURATION);
                }else if (item.equals("Dar de baja")){
                    details(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        linear = (ViewGroup)view.findViewById(R.id.details);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(parent.getContext(),android.R.layout.simple_spinner_dropdown_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(parent.getContext(),android.R.layout.simple_spinner_dropdown_item,data1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quiero.setAdapter(adapter);
        motivo.setAdapter(adapter1);
        return new ViewHodlder(view);
    }

    private void details(View view) {
        if (linear.getVisibility() == View.GONE){
            ExpandAndCollapseViewUtil.expand(linear, DURATION);
        }else {
            ExpandAndCollapseViewUtil.collapse(linear, DURATION);
        }
    }


    @Override
    public void onBindViewHolder(ViewHodlder holder, int position) {

    }
}
