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

    TextView txtNotification,txtPanorama;

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

        txtNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 1;
                txtNotification.setTextColor(Color.parseColor("#FB8C00"));
                txtPanorama.setTextColor(Color.parseColor("#000000"));
                fragments(count);
            }
        });

        txtPanorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                txtNotification.setTextColor(Color.parseColor("#000000"));
                txtPanorama.setTextColor(Color.parseColor("#FB8C00"));
                fragments(count);
            }
        });


        //txtPanorama.setTextColor(R.color.colorPrimary);

        return view;
    }

    private void fragments(int count) {
        Fragment fragment = null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (count == 0){
            Log.e("TAG",String.valueOf(count));
            fragment = new TestFragment();
        }else if (count == 1){
            fragment = new TestFragment2();
        }
        if (fragment!=null){
            transaction.replace(R.id.content,fragment)
            .addToBackStack(null).commit();
            //transaction.add(R.id.content,fragment).commit();
        }
    }
}
