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

import com.example.clickit.demoseguro.Adapters.AdaptadorMisPolizas;
import com.example.clickit.demoseguro.Clases.RecyclerItemClickListener;
import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 14/08/16.
 */
public class PolizasFragment extends Fragment {

    public static final String TAG = PolizasFragment.class.getSimpleName();
    private LinearLayoutManager linearLayoutManager;

    public PolizasFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_polizas,container,false);

        final RecyclerView listaPolizas = (RecyclerView)view.findViewById(R.id.mis_polizas);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listaPolizas.setLayoutManager(linearLayoutManager);

        final AdaptadorMisPolizas adaptadorMisPolizas = new AdaptadorMisPolizas();
        listaPolizas.setAdapter(adaptadorMisPolizas);
        /*listaPolizas.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View childView, int position) {
                adaptadorMisPolizas.onBindViewHolder(childView,position);
            }

            @Override
            public void onItemLongPress(View childView, int position) {

            }

        }));*/
        return view;
    }
}
