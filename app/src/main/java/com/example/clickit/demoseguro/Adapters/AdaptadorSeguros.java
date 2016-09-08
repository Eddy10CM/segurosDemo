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
public class AdaptadorSeguros extends RecyclerView.Adapter<AdaptadorSeguros.ViewHolder> {

    public String info = "";



    public void envioDatos(String item) {
        info = item;
    }

    public AdaptadorSeguros() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */
        TextView costoTotal,primRecivo,proxRecivo;

        public ViewHolder(View itemView) {
            super(itemView);
            costoTotal = (TextView)itemView.findViewById(R.id.costo);
            primRecivo = (TextView)itemView.findViewById(R.id.prim_recivo);
            proxRecivo = (TextView)itemView.findViewById(R.id.prox_reciv);
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

            holder.costoTotal.setText("$23,500");
            holder.primRecivo.setText("$7,500");
            holder.proxRecivo.setText("$6,450");
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
