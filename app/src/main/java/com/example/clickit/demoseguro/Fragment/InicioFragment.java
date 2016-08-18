package com.example.clickit.demoseguro.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

import static com.example.clickit.demoseguro.R.color.colorPrimary;

public class InicioFragment extends Fragment {


    int count = 0;
    public InicioFragment(){}

    TextView txtNotification,txtPanorama,txtConfiguration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio,container,false);

        txtNotification = (TextView)view.findViewById(R.id.txt_notificacion);

        /*final Fragment test = new TestFragment();
        FragmentTransaction transaction transaction = getChildFragmentManager()
                .beginTransaction();
        transaction.add(R.id.content,test).addToBackStack("TEST").commit();*/

        fragments(count);

        txtPanorama = (TextView)view.findViewById(R.id.txt_panorama);

        txtConfiguration = (TextView)view.findViewById(R.id.txt_configuracion);

        txtPanorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                txtPanorama.setTextColor(Color.parseColor("#FB8C00"));
                txtNotification.setTextColor(Color.parseColor("#000000"));
                txtConfiguration.setTextColor(Color.parseColor("#000000"));
                fragments(count);
            }
        });

        txtNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 1;
                txtNotification.setTextColor(Color.parseColor("#FB8C00"));
                txtPanorama.setTextColor(Color.parseColor("#000000"));
                txtConfiguration.setTextColor(Color.parseColor("#000000"));
                fragments(count);
            }
        });


        txtConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 2;
                txtConfiguration.setTextColor(Color.parseColor("#FB8C00"));
                txtNotification.setTextColor(Color.parseColor("#000000"));
                txtPanorama.setTextColor(Color.parseColor("#000000"));
                fragments(count);
            }
        });
        
        return view;
    }

    private void fragments(int count) {
        Fragment fragment = null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (count == 0){
            fragment = new TestFragment();
        }else if (count == 1){
            fragment = new TestFragment2();
        }else if (count == 2){
            fragment = new TestFragment3();
        }
        if (fragment!=null){
            transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out).replace(R.id.content,fragment)
            .commit();
            //transaction.add(R.id.content,fragment).addToBackStack(null).commit();
        }
    }


}
