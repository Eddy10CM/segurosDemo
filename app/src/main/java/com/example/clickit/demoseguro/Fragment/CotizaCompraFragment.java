package com.example.clickit.demoseguro.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clickit.demoseguro.Adapters.AdaptadorSecciones;
import com.example.clickit.demoseguro.R;

/**
 * Fragment of the section "Cotiza y Compra"
 */

public class CotizaCompraFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    public final static String KEY = "KEY";


    public CotizaCompraFragment(){}

    public static CotizaCompraFragment newInstance(String title){
        CotizaCompraFragment cotizaCompraFragment = new CotizaCompraFragment();
        Bundle args = new Bundle();

        Log.e("TAG",title);
        return cotizaCompraFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza_compra,container,false);

        if (savedInstanceState == null){
            insertTabs(container);

            //Setear adapter the viewpager
            viewPager = (ViewPager)view.findViewById(R.id.pager);
            poblarViewPager(viewPager);
            tabs.setupWithViewPager(viewPager);
        }

        return view;
    }

    private void poblarViewPager(ViewPager viewPager) {
        AdaptadorSecciones adapter = new AdaptadorSecciones(getFragmentManager());
        adapter.addFragment(new SeleccionaVehiculoFragment(),getString(R.string.titulo_seleciona_vehiculo));
        adapter.addFragment(new CotizaFragment(),getString(R.string.cotiza_compra));
        viewPager.setAdapter(adapter);
    }

    private void insertTabs(ViewGroup container) {
        View padre = (View)container.getParent();
        appBar = (AppBarLayout)padre.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }

}
