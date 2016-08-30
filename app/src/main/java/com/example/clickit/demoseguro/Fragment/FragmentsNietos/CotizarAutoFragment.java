package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.clickit.demoseguro.Adapters.ExpandAndCollapseViewUtil;
import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 29/08/16.
 */
public class CotizarAutoFragment extends Fragment {

    Button btnSpinner,btnCerrarBack;
    ViewGroup lista;
    private static final int DURATION = 250;
    private LinearLayoutManager linearLayoutManager;
    RecyclerView listaAutos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza_auto,container,false);

        btnSpinner = (Button)view.findViewById(R.id.spinner_autos);

        lista = (ViewGroup)view.findViewById(R.id.collapsable_list);

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpandAndCollapseViewUtil.expand(lista, DURATION);
            }
        });

        btnCerrarBack = (Button)view.findViewById(R.id.btn_cerrar_and_back);

        btnCerrarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpandAndCollapseViewUtil.collapse(lista,DURATION);
            }
        });

        listaAutos = (RecyclerView)view.findViewById(R.id.items_seleccionables);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listaAutos.setLayoutManager(linearLayoutManager);

        return view;
    }
}
