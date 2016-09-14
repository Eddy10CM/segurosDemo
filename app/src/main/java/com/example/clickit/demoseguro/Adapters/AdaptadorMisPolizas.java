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

    public static final String TAG = AdaptadorMisPolizas.class.getSimpleName();


    private static final int DURATION = 250;
    ArrayAdapter<String> adapter;
    //private int flip = -1,flipBack = -1;


    public static class ViewHodlder extends RecyclerView.ViewHolder {

        Spinner quiero,motivo;
        ViewGroup linearDetails,linearPrincipal;
        Button btnVolver;
        TextView txtDetalles;


        public ViewHodlder(View itemView) {
            super(itemView);
            quiero = (Spinner)itemView.findViewById(R.id.quiero_polizas);
            motivo = (Spinner)itemView.findViewById(R.id.motivo);
            btnVolver = (Button)itemView.findViewById(R.id.volver);
            txtDetalles = (TextView)itemView.findViewById(R.id.txtDetalles);
            linearDetails = (ViewGroup)itemView.findViewById(R.id.details);
            linearPrincipal = (ViewGroup)itemView.findViewById(R.id.linear_principal);

        }
    }

    public AdaptadorMisPolizas() {
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public ViewHodlder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_polizas,parent,false);
        myContext = parent.getContext();
        ViewHodlder hol = new ViewHodlder(view);
        return hol;
    }

    /*private void details(View view) {
        if (linearDetails.getVisibility() == View.GONE){
            ExpandAndCollapseViewUtil.expand(linearDetails, DURATION);
        }else {
            ExpandAndCollapseViewUtil.collapse(linearDetails, DURATION);
        }
    }*/


    @Override
    public void onBindViewHolder(final ViewHodlder holder, final int position) {
        //test.setText(String.valueOf(position));


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


        adapter = new ArrayAdapter<>(myContext,android.R.layout.simple_spinner_dropdown_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(myContext,android.R.layout.simple_spinner_dropdown_item,data1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        holder.quiero.setAdapter(adapter);
        holder.motivo.setAdapter(adapter1);

        holder.txtDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //holder.txtDetalles.setText("HOLA " + position);
                //notifyItemChanged(position);

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




        holder.quiero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:break;
                    case 1:

                            //notifyItemChanged(flip);
                            //}

                        //Log.e("TAG" + position,"Animación");
                        //
                        //Log.e("POSICIONES",String.valueOf(position)+" " + String.valueOf(flip));
                        //if (position == flip){
                            if (holder.linearDetails.getVisibility() == View.GONE){
                                Animation animation = AnimationUtils.loadAnimation(myContext,R.anim.car_flip_left_in);
                                holder.linearDetails.startAnimation(animation);
                                //animar(true);
                                holder.linearDetails.setVisibility(View.VISIBLE);
                                holder.linearPrincipal.setVisibility(View.GONE);

                                //notifyDataSetChanged();
                                //notifyItemChanged(position);
                            }//else
                        //}
                        //flip = -1;
                        break;
                    case 2:break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        holder.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //notifyItemChanged(flip);


                    if (holder.linearPrincipal.getVisibility() == View.GONE){
                        Animation animation = AnimationUtils.loadAnimation(myContext,R.anim.car_flip_left_in);
                        holder.linearPrincipal.startAnimation(animation);
                        //animar(true);
                        holder.linearPrincipal.setVisibility(View.VISIBLE);
                        holder.linearDetails.setVisibility(View.GONE);
                        holder.quiero.setSelection(0);
                        //adapter.clear();

                    }


                //flipBack = -1;
                    //
                //}
                //ExpandAndCollapseViewUtil.collapse(linearDetails, DURATION);
            }
        });

        //Log.e("TAG",quiero.getSelectedItem().toString());
    }

    /*public void testForId(int position){
        Log.e(TAG,String.valueOf(position));
        txtDetalles.setText(TAG + position);
    }*/



    /*private void setAimationBack(ViewGroup viewGroup, int position) {
        if (position > flipBack){
            Animation animation = AnimationUtils.loadAnimation(myContext,R.anim.car_flip_left_in);
            viewGroup.startAnimation(animation);
            flipBack = position;
            linearDetails.setVisibility(View.GONE);
            linearPrincipal.setVisibility(View.VISIBLE);
            notifyItemChanged(flipBack);
        }
    }

    private void setAnimation(ViewGroup viewGroup, int position) {
        //if (position > flip){
            Log.e("TAG",String.valueOf(position) + " " + String.valueOf(flip));
            flip = position;
            notifyItemChanged(flip);
            Animation animation = AnimationUtils.loadAnimation(myContext,R.anim.car_flip_left_in);
            viewGroup.getChildAt(position).startAnimation(animation);
            linearPrincipal.setVisibility(View.GONE);
            linearDetails.setVisibility(View.VISIBLE);
        //}
    }*/



    /*private void animar(boolean mostrar)
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
    }*/
}
