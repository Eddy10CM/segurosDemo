package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.clickit.demoseguro.Adapters.AdaptadorListaSpinnerAutos;
import com.example.clickit.demoseguro.Adapters.ExpandAndCollapseViewUtil;
import com.example.clickit.demoseguro.Clases.ListaAutos;
import com.example.clickit.demoseguro.Clases.RecyclerItemClickListener;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;

/**
 * Created by clickit on 29/08/16.
 */
public class CotizarAutoFragment extends Fragment {

    Button btnSpinner,btnCerrarBack;
    ViewGroup lista;
    TextView txtCambia;
    private String [] modelos;
    private String [] marca;
    private String [] linea;
    private String [] descripcion;
    private ArrayList<ListaAutos> listaAutoses = new ArrayList<>();
    private static final int DURATION = 250;
    private LinearLayoutManager linearLayoutManager;
    RecyclerView listaAutos;
    int count = 0;
    private AdaptadorListaSpinnerAutos adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza_auto,container,false);

        btnSpinner = (Button)view.findViewById(R.id.spinner_autos);

        lista = (ViewGroup)view.findViewById(R.id.collapsable_list);
        txtCambia = (TextView)view.findViewById(R.id.txt_cambia);
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
        adapter = new AdaptadorListaSpinnerAutos(getActivity());
        listaAutos.setAdapter(adapter);
        modelos = getActivity().getResources().getStringArray(R.array.modelos);
        marca = getActivity().getResources().getStringArray(R.array.marcas);
        linea = getActivity().getResources().getStringArray(R.array.lineas);
        descripcion = getActivity().getResources().getStringArray(R.array.descripcion);

        for (int i=0; i<modelos.length; i++){
            ListaAutos test = new ListaAutos();
            test.setLista(modelos[i]);
            listaAutoses.add(test);
        }
        adapter.setItems(listaAutoses);

        listaAutos.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View childView, int position) {
                ListaAutos items = listaAutoses.get(position);
                if (count==0){
                    btnSpinner.setText(items.getLista());
                    btnCerrarBack.setText("Modelo");
                    txtCambia.setText("Marca");
                    adapter.clear();
                    for (int i=0; i<marca.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(marca[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 1;
                }else if (count==1){
                    String queTieneElBoton = btnSpinner.getText().toString();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnCerrarBack.setText("Marca");
                    txtCambia.setText("Línea");
                    adapter.clear();
                    for (int i=0; i<linea.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(linea[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 2;
                }else if (count==2){
                    String queTieneElBoton = btnSpinner.getText().toString();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnCerrarBack.setText("Línea");
                    txtCambia.setText("Descripción");
                    adapter.clear();
                    for (int i=0; i<descripcion.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(descripcion[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 3;
                }else if (count==3){
                    String queTieneElBoton = btnSpinner.getText().toString();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnCerrarBack.setText("Línea");
                    txtCambia.setText("Descripción");
                    ExpandAndCollapseViewUtil.collapse(lista,DURATION);
                    count = 4;
                }
            }

            @Override
            public void onItemLongPress(View childView, int position) {

            }
        }));

        return view;
    }
}
