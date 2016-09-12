package com.example.clickit.demoseguro.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.clickit.demoseguro.Clases.ListaAutos;
import com.example.clickit.demoseguro.Clases.ListaSeleccion;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by clickit on 29/08/16.
 */
public class AdaptadorSpinnerSeleccion extends RecyclerView.Adapter<AdaptadorSpinnerSeleccion.ViewHolderSeleccion>{

    private ArrayList<ListaSeleccion> data = new ArrayList<>();
    private LayoutInflater inflater;
    Context myContext;

    public class ViewHolderSeleccion extends RecyclerView.ViewHolder {
        Button btnSeleccionModificable;
        public ViewHolderSeleccion(View itemView) {
            super(itemView);
            btnSeleccionModificable = (Button)itemView.findViewById(R.id.btn_modificable);
        }
    }

    public AdaptadorSpinnerSeleccion(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void setItems(ArrayList<ListaSeleccion>data){
        this.data = data;
        notifyItemRangeChanged(0,data.size());
    }

    public void addAll(List<ListaSeleccion>list){
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public ViewHolderSeleccion onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_seleccion,parent,false);
        ViewHolderSeleccion viewHolderAutos = new ViewHolderSeleccion(view);
        myContext = parent.getContext();
        return viewHolderAutos;
    }

    @Override
    public void onBindViewHolder(ViewHolderSeleccion holder, int position) {
        ListaSeleccion datos = data.get(position);
        holder.btnSeleccionModificable.setText(datos.getTitulo());
        switch (position){
            case 0:
                holder.btnSeleccionModificable.setCompoundDrawablesWithIntrinsicBounds(myContext.getResources().getDrawable(R.drawable.car_naranja_button1),null,null,null);
                break;
            case 1:
                holder.btnSeleccionModificable.setCompoundDrawablesWithIntrinsicBounds(myContext.getResources().getDrawable(R.drawable.corazon_naranja_button),null,null,null);
                break;
            case 2:
                holder.btnSeleccionModificable.setCompoundDrawablesWithIntrinsicBounds(myContext.getResources().getDrawable(R.drawable.injury_orange),null,null,null);
                break;
            default:
                break;
        }
    }

}
