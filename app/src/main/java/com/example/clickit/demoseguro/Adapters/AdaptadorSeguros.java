package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 12/08/16.
 */
public class AdaptadorSeguros extends RecyclerView.Adapter<AdaptadorSeguros.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public AdaptadorSeguros(){}

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

    }


}
