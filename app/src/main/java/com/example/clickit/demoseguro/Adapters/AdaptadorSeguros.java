package com.example.clickit.demoseguro.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.Clases.ListaAutos;
import com.example.clickit.demoseguro.Clases.ListaSeguros;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by clickit on 12/08/16.
 */
public class AdaptadorSeguros extends RecyclerView.Adapter<AdaptadorSeguros.ViewHolder> {

    public String info = "";
    private static final int DURATION = 250;
    private ArrayList<ListaSeguros> data = new ArrayList<>();
    Context myContext;
    private LayoutInflater inflater;
    public static final String TAG = AdaptadorSeguros.class.getSimpleName();



    public AdaptadorSeguros(String dato,String dato1) {
        Log.e("TAG",dato + " " + dato1);
    }

    public AdaptadorSeguros() {
    }

    public AdaptadorSeguros(Context context) {
        this.inflater = LayoutInflater.from(context);;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Aqui van los campos a usar en la lista personalizada
         * */
        TextView txtDetalles,txtCosto,txtError;
        ViewGroup linear,linearPrincipal,linearSecundario;
        CardView card;
        public ViewHolder(View itemView) {
            super(itemView);
            txtDetalles = (TextView)itemView.findViewById(R.id.detalles);
            txtCosto = (TextView)itemView.findViewById(R.id.txt_costo);
            linear = (ViewGroup)itemView.findViewById(R.id.linear_expa);
            linearPrincipal = (ViewGroup)itemView.findViewById(R.id.car_principal);
            linearSecundario = (ViewGroup)itemView.findViewById(R.id.car_secundaria);
            card = (CardView)itemView.findViewById(R.id.card);
            txtError = (TextView)itemView.findViewById(R.id.error);
        }
    }

    public void setItems(ArrayList<ListaSeguros>data){
        this.data = data;
        notifyItemRangeChanged(0,data.size());
    }

    public void addAll(List<ListaSeguros>list){
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seguros,parent,false);
        myContext = parent.getContext();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ListaSeguros item = data.get(position);
        Log.e(TAG,item.toString());
        if (data.size()>1){
            if (holder.linearPrincipal.getVisibility() == View.GONE){
                ExpandAndCollapseViewUtil.expand(holder.linearPrincipal,DURATION);
                ExpandAndCollapseViewUtil.collapse(holder.linearSecundario,DURATION);
            }
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
            holder.txtCosto.setText(item.getCosto());
        }else{
            if (holder.linearSecundario.getVisibility() == View.GONE){
                holder.card.setCardBackgroundColor(myContext.getResources().getColor(R.color.fondo_seguros_inexistentes));
                ExpandAndCollapseViewUtil.expand(holder.linearSecundario,DURATION);
                ExpandAndCollapseViewUtil.collapse(holder.linearPrincipal,DURATION);
                //holder.txtError.setText();
            }
        }
    }

    /*public static void recibe(String dato,String dato1){
        Log.e("TAG",dato + " " + dato1);
    }*/

    /*public static class Datos {
        private static String paquete,formaPago;
        public String costo;

        public Datos(String costo) {
            this.costo = costo;
        }

        public static List<Datos> DATOS = new ArrayList<>();

        public static void recibirPaquete(String item1){
            paquete = item1;
            Log.e("TAG: ", paquete);
            if (paquete.equals("Amplia")){
                DATOS.add(new Datos("$2,300"));
                DATOS.add(new Datos("$4,300"));
                DATOS.add(new Datos("$8,300"));
            }else if (paquete.equals("Limitada")){
                DATOS.add(new Datos("$9,300"));
                DATOS.add(new Datos("$3,300"));
                DATOS.add(new Datos("$5,300"));
            }else if (paquete.equals("RC")){
                DATOS.add(new Datos("$6,300"));
                DATOS.add(new Datos("$1,300"));
                DATOS.add(new Datos("$3,300"));
            }
        }

        public static void recibirFormaPago(String item2){
            formaPago = item2;
        }
    }*/
}
