package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 12/08/16.
 */
public class AdaptadorSeguros extends RecyclerView.Adapter<AdaptadorSeguros.ViewHolder> {

    private String paquete,formaDePago;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */
        TextView costoTotal;

        public ViewHolder(View itemView) {
            super(itemView);
            costoTotal = (TextView)itemView.findViewById(R.id.costo);
        }
    }

    public AdaptadorSeguros() {
        this.paquete = paquete;
        this.formaDePago = formaDePago;

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seguros,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.costoTotal.setText(paquete);
    }


}
