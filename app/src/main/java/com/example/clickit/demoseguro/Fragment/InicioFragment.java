package com.example.clickit.demoseguro.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.R;

public class InicioFragment extends Fragment {
    private String title;
    public InicioFragment(){}

    @SuppressLint("ValidFragment")
    public InicioFragment(String title){
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio,container,false);
        TextView title_ = (TextView)view.findViewById(R.id.title_fragment);
        title_.setText(title);
        return view;
    }
}
