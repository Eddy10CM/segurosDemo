package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clickit.demoseguro.Adapters.AdaptadorNotificaciones;
import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 16/08/16.
 */
public class TestFragment2 extends Fragment {

    RecyclerView recyclerView;
    AdaptadorNotificaciones adaptadorNotificaciones;
    LinearLayoutManager linearLayoutManager;

    public TestFragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test2,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_notificaciones);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adaptadorNotificaciones = new AdaptadorNotificaciones();
        recyclerView.setAdapter(adaptadorNotificaciones);
        return view;
    }
}
