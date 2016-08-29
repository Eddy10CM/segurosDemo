package com.example.clickit.demoseguro.Fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.clickit.demoseguro.R;

/**
 * Fragment of the section "Cotiza y Compra"
 */

public class CotizaCompraFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    Button btnCotizaCompraAuto,btnCotizaCompraVida,btnCotizaCompraFuneraria;
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

        /*if (savedInstanceState == null){
            insertTabs(container);

            //Setear adapter the viewpager
            viewPager = (ViewPager)view.findViewById(R.id.pager);
            poblarViewPager(viewPager);
            tabs.setupWithViewPager(viewPager);
        }*/


        btnCotizaCompraAuto = (Button)view.findViewById(R.id.btn_cotiza_auto);

        btnCotizaCompraAuto.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_blanco_button),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_naranja_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));

                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_orange),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));
            }
        });

        btnCotizaCompraVida = (Button)view.findViewById(R.id.btn_cotiza_vida);

        btnCotizaCompraVida.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_blanco_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_naranja_button1),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));


                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_orange),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));
            }
        });

        btnCotizaCompraFuneraria = (Button)view.findViewById(R.id.btn_cotiza_funeraria);
        btnCotizaCompraFuneraria.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_blanco),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_naranja_button1),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));


                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_naranja_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));
            }
        });

        return view;
    }

    /*private void poblarViewPager(ViewPager viewPager) {
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
    }*/

}
