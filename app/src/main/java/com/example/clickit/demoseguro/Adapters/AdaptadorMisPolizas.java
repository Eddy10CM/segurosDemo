package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 14/08/16.
 */
public class AdaptadorMisPolizas extends RecyclerView.Adapter<AdaptadorMisPolizas.ViewHodlder> {


    Spinner quiero,motivo;
    ViewGroup linear;
    Button btnVolver;
    TextView txtDetalles;
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
    public ViewHodlder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_polizas,parent,false);

        quiero = (Spinner)view.findViewById(R.id.quiero_polizas);
        motivo = (Spinner)view.findViewById(R.id.motivo);
        btnVolver = (Button)view.findViewById(R.id.volver);
        txtDetalles = (TextView)view.findViewById(R.id.txtDetalles);


        final List<String> data = new ArrayList<>();
        data.add("Seleccione");
        data.add("Dar de baja");


        List<String> data1 = new ArrayList<>();
        data1.add("Seleccione");
        data1.add("Error de captura");
        data1.add("Baja de unidad");
        data1.add("Perdida Total/Robo de la unidad");
        data1.add("Unidad ya asegurada(Duplicada)");
        data1.add("Cambio de cobertura");
        data1.add("Cambio de aseguradora");

        txtDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG","SE presiono el texto");
                View popUp = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data,null);
                final PopupWindow popupWindow = new PopupWindow(popUp, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                Button back = (Button)popUp.findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAsDropDown(popUp, 100,300);
            }
        });



        quiero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                if (item.equals("Seleccione")){
                }else if (item.equals("Dar de baja")){
                    linear.setVisibility(View.VISIBLE);
                    //ExpandAndCollapseViewUtil.expand(linear, DURATION);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiero.setSelection(0);
                linear.setVisibility(View.GONE);
                //ExpandAndCollapseViewUtil.collapse(linear, DURATION);
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
