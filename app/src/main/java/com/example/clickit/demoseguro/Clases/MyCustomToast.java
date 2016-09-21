package com.example.clickit.demoseguro.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clickit.demoseguro.R;

import org.w3c.dom.Text;

/**
 * Created by clickit on 21/09/16.
 */
public class MyCustomToast extends Toast {

    private Context context;

    /**
     * Constructor que recibe el contexto y la duracion del Toast
     * que se le pasara al método setDuration de la clase heredada
     */
    public MyCustomToast(Context context,int duration) {
        super(context);
        this.context = context;
        this.setDuration(duration);
    }

    /**
     * Método donde inflamos nuestro layout personalizado y le asignamos
     * el texto a mostrar
     */
    public void show(CharSequence text){
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (View)li.inflate(R.layout.custom_layout_toast,null);

        TextView txtMostrar = (TextView)view.findViewById(R.id.txt_toast_custom);
        this.setView(view);
        txtMostrar.setText(text);
        super.show();
    }
}
