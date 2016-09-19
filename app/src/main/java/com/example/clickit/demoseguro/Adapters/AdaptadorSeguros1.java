package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clickit on 12/08/16.
 */
public class AdaptadorSeguros1 extends RecyclerView.Adapter<AdaptadorSeguros1.ViewHolder> {

    public String info = "";



    public void envioDatos(String item) {
        info = item;
    }

    public AdaptadorSeguros1() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */
        TextView costoTotal,primRecivo,proxRecivo;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }



    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seguros,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



    }

    public static class Datos{
        public String costoTotal;



        public Datos(String costoTotal) {
            this.costoTotal = costoTotal;
        }


        public final static List<Datos> DIRECCIONES = new ArrayList<>();

        static {
            DIRECCIONES.add(new Datos("$23,500"));
            DIRECCIONES.add(new Datos("$23,500"));
            DIRECCIONES.add(new Datos("$23,500"));
        }
    }
}
