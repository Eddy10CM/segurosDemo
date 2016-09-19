package com.example.clickit.demoseguro.Adapters;

import android.content.Context;
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

    public String info = "";
    private static final int DURATION = 250;
    Context myContext;
    public static final String TAG = AdaptadorSeguros.class.getSimpleName();



    public AdaptadorSeguros(String dato,String dato1) {
        Log.e("TAG",dato + " " + dato1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */
        TextView txtDetalles;
        ViewGroup linear;
        public ViewHolder(View itemView) {
            super(itemView);
            txtDetalles = (TextView)itemView.findViewById(R.id.detalles);
            linear = (ViewGroup)itemView.findViewById(R.id.linear_expa);
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
        myContext = parent.getContext();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.txtDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.linear.getVisibility() == View.GONE){
                    ExpandAndCollapseViewUtil.expand(holder.linear,DURATION);
                    holder.txtDetalles.setCompoundDrawablesWithIntrinsicBounds(myContext.getResources().getDrawable(R.drawable.menos),null,null,null);
                }else if (holder.linear.getVisibility() == View.VISIBLE){
                    ExpandAndCollapseViewUtil.collapse(holder.linear,DURATION);
                    holder.txtDetalles.setCompoundDrawablesWithIntrinsicBounds(myContext.getResources().getDrawable(R.drawable.mas),null,null,null);
                }
            }
        });
    }

    /*public static void recibe(String dato,String dato1){
        Log.e("TAG",dato + " " + dato1);
    }*/
}
