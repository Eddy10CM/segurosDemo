package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clickit.demoseguro.R;

import java.util.ArrayList;

/**
 * Created by clickit on 23/08/16.
 */
public class ContactoFragment extends Fragment {
    @Nullable
    Spinner departamentospinner;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacto,container,false);
        departamentospinner =(Spinner) view.findViewById(R.id.departamentospinner);

        ArrayList<String> departamentolist = new ArrayList<String>();
        departamentolist.add("Seleccione");
        departamentolist.add("Soporte");
        departamentolist.add("Ventas");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, departamentolist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        departamentospinner.setAdapter(adapter);

        return view;
    }
}
