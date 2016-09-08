package com.example.clickit.demoseguro.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 14/08/16.
 */
public class AdaptadorMisPolizas extends RecyclerView.Adapter<AdaptadorMisPolizas.ViewHodlder> {

    Context myContext;

    Spinner quiero,motivo;
    ViewGroup linearDetails,linearPrincipal;
    Button btnVolver;
    TextView txtDetalles,test;
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
        return 2;
    }

    @Override
    public ViewHodlder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_polizas,parent,false);

        quiero = (Spinner)view.findViewById(R.id.quiero_polizas);
        motivo = (Spinner)view.findViewById(R.id.motivo);
        btnVolver = (Button)view.findViewById(R.id.volver);
        txtDetalles = (TextView)view.findViewById(R.id.txtDetalles);
        linearDetails = (ViewGroup)view.findViewById(R.id.details);
        linearPrincipal = (ViewGroup)view.findViewById(R.id.linear_principal);
        test = (TextView)view.findViewById(R.id.test_txt);

        myContext = parent.getContext();

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







        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiero.setSelection(0);
                if (linearPrincipal.getVisibility() == View.GONE){
                    Animation animation= AnimationUtils.loadAnimation(parent.getContext(),R.anim.car_flip_right_out);
                    linearPrincipal.startAnimation(animation);
                    //animar(true);
                    linearPrincipal.setVisibility(View.VISIBLE);
                    linearDetails.setVisibility(View.GONE);
                }
                //ExpandAndCollapseViewUtil.collapse(linearDetails, DURATION);
            }
        });




        ArrayAdapter<String> adapter = new ArrayAdapter<>(parent.getContext(),android.R.layout.simple_spinner_dropdown_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(parent.getContext(),android.R.layout.simple_spinner_dropdown_item,data1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quiero.setAdapter(adapter);
        motivo.setAdapter(adapter1);
        return new ViewHodlder(view);
    }

    private void details(View view) {
        if (linearDetails.getVisibility() == View.GONE){
            ExpandAndCollapseViewUtil.expand(linearDetails, DURATION);
        }else {
            ExpandAndCollapseViewUtil.collapse(linearDetails, DURATION);
        }
    }


    @Override
    public void onBindViewHolder(ViewHodlder holder, final int position) {
        test.setText(String.valueOf(position));

        txtDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*View popUp = LayoutInflater.from(myContext).inflate(R.layout.show_data,null);
                final PopupWindow popupWindow = new PopupWindow(popUp, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                Button back = (Button)popUp.findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAsDropDown(popUp, 100,300);*/
            }
        });



        quiero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:break;
                    case 1:
                        Log.e("TAG" + position,"Animación");
                        if (position==0){
                            if (linearDetails.getVisibility() == View.GONE){
                                Animation animation= AnimationUtils.loadAnimation(myContext,R.anim.car_flip_left_in);
                                linearDetails.startAnimation(animation);
                                //animar(true);
                                linearDetails.setVisibility(View.VISIBLE);
                                linearPrincipal.setVisibility(View.GONE);
                            }
                        }
                        break;
                    case 2:break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void animar(boolean mostrar)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else
        {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);

        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        linearDetails.setLayoutAnimation(controller);
        linearDetails.startAnimation(animation);
    }
}
