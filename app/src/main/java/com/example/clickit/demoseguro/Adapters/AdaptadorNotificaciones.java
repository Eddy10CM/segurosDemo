package com.example.clickit.demoseguro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 19/08/16.
 */
public class AdaptadorNotificaciones extends RecyclerView.Adapter<AdaptadorNotificaciones.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btnNotification;
        TextView txtFecha,txtTipo,txtNotificacion;

        public ViewHolder(View itemView) {
            super(itemView);
            btnNotification = (Button)itemView.findViewById(R.id.btn_notificacion);
            txtFecha = (TextView)itemView.findViewById(R.id.txt_fecha_notificacion);
            txtTipo = (TextView)itemView.findViewById(R.id.txt_renovacion);
            txtNotificacion = (TextView)itemView.findViewById(R.id.txt_notificacion);
            txtFecha.setSelected(true);
            txtTipo.setSelected(true);
            txtNotificacion.setSelected(true);

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
        return 10;
    }

}
