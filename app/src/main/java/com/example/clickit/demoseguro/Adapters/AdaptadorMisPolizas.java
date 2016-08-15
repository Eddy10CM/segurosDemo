package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 14/08/16.
 */
public class AdaptadorMisPolizas extends RecyclerView.Adapter<AdaptadorMisPolizas.ViewHodlder> {


    Spinner quiero;

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

        List<String> data = new ArrayList<>();
        data.add("Seleccione");
        data.add("Dar de baja");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_spinner_dropdown_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quiero.setAdapter(adapter);
        return new ViewHodlder(view);
    }

    @Override
    public void onBindViewHolder(ViewHodlder holder, int position) {

    }
}
