package com.example.clickit.demoseguro.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.Clases.ListaAutos;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by clickit on 29/08/16.
 */
public class AdaptadorListaSpinnerAutos extends RecyclerView.Adapter<AdaptadorListaSpinnerAutos.ViewHolderAutos>{

    private ArrayList<ListaAutos> data = new ArrayList<>();
    private LayoutInflater inflater;

    public class ViewHolderAutos extends RecyclerView.ViewHolder {
        public TextView txtItemRecicable;
        public ViewHolderAutos(View itemView) {
            super(itemView);
            txtItemRecicable = (TextView)itemView.findViewById(R.id.txt_item_modificable);
        }
    }

    public AdaptadorListaSpinnerAutos(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void setItems(ArrayList<ListaAutos>data){
        this.data = data;
        notifyItemRangeChanged(0,data.size());
    }

    public void addAll(List<ListaAutos>list){
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
    public ViewHolderAutos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_autos,parent,false);
        ViewHolderAutos viewHolderAutos = new ViewHolderAutos(view);
        return viewHolderAutos;
    }

    @Override
    public void onBindViewHolder(ViewHolderAutos holder, int position) {
        ListaAutos datos = data.get(position);
        holder.txtItemRecicable.setText(datos.getLista());
    }

}
