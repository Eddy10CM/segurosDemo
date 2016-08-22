package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 19/08/16.
 */
public class AdaptadorNotificaciones extends RecyclerView.Adapter<AdaptadorNotificaciones.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btnNotification;
        public ViewHolder(View itemView) {
            super(itemView);
            btnNotification = (Button)itemView.findViewById(R.id.btn_notificacion);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notificaciones,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
