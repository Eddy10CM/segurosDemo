package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 16/08/16.
 */
public class TestFragment extends Fragment {

    TextView test;



    public TestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,container,false);

        test = (TextView)view.findViewById(R.id.prueba);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG","CLICK");
                Bundle args = new Bundle();
                Fragment fragment = CotizaCompraFragment.newInstance("Cotiza");
                args.putString(CotizaCompraFragment.KEY,"Cotiza");
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedor_principal,fragment).commit();
            }
        });

        return view;
    }
}
