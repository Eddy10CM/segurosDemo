package com.example.clickit.demoseguro.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.clickit.demoseguro.Adapters.AdaptadorSpinnerSeleccion;
import com.example.clickit.demoseguro.Adapters.ExpandAndCollapseViewUtil;
import com.example.clickit.demoseguro.Clases.ListaSeleccion;
import com.example.clickit.demoseguro.Clases.RecyclerItemClickListener;
import com.example.clickit.demoseguro.Fragment.FragmentsNietos.CotizarAutoFragment;
import com.example.clickit.demoseguro.Fragment.FragmentsNietos.CotizarVidaFragment;
import com.example.clickit.demoseguro.R;

import java.util.ArrayList;

/**
 * Fragment of the section "Cotiza y Compra"
 */

public class CotizaCompraFragment extends Fragment {


    private AdaptadorSpinnerSeleccion adapter;
    private LinearLayoutManager linearLayoutManager;
    ViewGroup listExpand;
    public static ViewGroup linearOcultar;
    RecyclerView listaSeleccion;
    int count;
    private static final int DURATION = 250;
    Button btnSeleccion;
    public final static String KEY = "KEY";

    private String [] seleccion;
    private boolean isPressed = false,isPressedAuto = true, isPressedVida = false, isPressedFuneraria = false;
    private ArrayList<ListaSeleccion> listaSeleccionados = new ArrayList<>();

    public CotizaCompraFragment(){}

    public CotizaCompraFragment(int count){
        this.count = count;
    }

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

        btnSeleccion = (Button)view.findViewById(R.id.btn_seleccion);
        adapter = new AdaptadorSpinnerSeleccion(getActivity());

        listExpand = (ViewGroup)view.findViewById(R.id.list_expand);
        linearOcultar = (ViewGroup)view.findViewById(R.id.a_ocultar);

        btnSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed){
                    ExpandAndCollapseViewUtil.expand(listExpand, DURATION);
                    isPressed=true;
                }else {
                    ExpandAndCollapseViewUtil.collapse(listExpand,DURATION);
                    isPressed = false;
                }
            }
        });

        seleccion = getActivity().getResources().getStringArray(R.array.selecciones);

        for (int i=0; i<seleccion.length; i++){
            ListaSeleccion test = new ListaSeleccion();
            test.setTitulo(seleccion[i]);
            listaSeleccionados.add(test);
        }

        adapter.setItems(listaSeleccionados);

        listaSeleccion = (RecyclerView)view.findViewById(R.id.lista_de_seleccion);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listaSeleccion.setLayoutManager(linearLayoutManager);
        listaSeleccion.setAdapter(adapter);

        final android.os.Handler mHandler = new android.os.Handler();

        listaSeleccion.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View childView, int position) {
                switch (position){
                    case 0:
                        btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_blanco_button),null,null,null);
                        btnSeleccion.setText("AUTO");
                        ExpandAndCollapseViewUtil.collapse(listExpand,DURATION);
                        isPressed = false;
                        if (!isPressedAuto){
                            fragments(position);
                            isPressedAuto = true;
                            isPressedVida = false;
                            isPressedFuneraria = false;
                        }
                        break;
                    case 1:
                        btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_blanco_button),null,null,null);
                        ExpandAndCollapseViewUtil.collapse(listExpand,DURATION);
                        btnSeleccion.setText("VIDA");
                        isPressed = false;
                        if (!isPressedVida){
                            fragments(position);
                            isPressedVida = true;
                            isPressedAuto = false;
                            isPressedFuneraria = false;
                        }
                        break;
                    case 2:
                        btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_blanco),null,null,null);
                        btnSeleccion.setText("GASTOS FUNERARIOS");
                        ExpandAndCollapseViewUtil.collapse(listExpand,DURATION);
                        if (!isPressedFuneraria){
                            fragments(position);
                            isPressedFuneraria = true;
                            isPressedVida = false;
                            isPressedAuto = false;
                        }
                        isPressed = false;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onItemLongPress(View childView, int position) {

            }
        }));



        /*if (savedInstanceState == null){
            insertTabs(container);

            //Setear adapter the viewpager
            viewPager = (ViewPager)view.findViewById(R.id.pager);
            poblarViewPager(viewPager);
            tabs.setupWithViewPager(viewPager);
        }*/


        /*btnCotizaCompraAuto = (Button)view.findViewById(R.id.btn_cotiza_auto);

        btnCotizaCompraAuto.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                count = 0;
                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_blanco_button),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_naranja_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));

                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_orange),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));

                fragments(count);
            }
        });

        btnCotizaCompraVida = (Button)view.findViewById(R.id.btn_cotiza_vida);

        btnCotizaCompraVida.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                count = 1;
                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_blanco_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_naranja_button1),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));


                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_orange),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));

                fragments(count);
            }
        });

        btnCotizaCompraFuneraria = (Button)view.findViewById(R.id.btn_cotiza_funeraria);
        btnCotizaCompraFuneraria.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                count = 2;
                btnCotizaCompraFuneraria.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_blanco),null,null,null);
                btnCotizaCompraFuneraria.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                btnCotizaCompraFuneraria.setBackground(getActivity().getResources().getDrawable(R.drawable.background_button_pop));

                btnCotizaCompraAuto.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_naranja_button1),null,null,null);
                btnCotizaCompraAuto.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraAuto.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));


                btnCotizaCompraVida.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_naranja_button),null,null,null);
                btnCotizaCompraVida.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                btnCotizaCompraVida.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_disable_cotiza_compra));

                fragments(count);
            }
        });*/

        Log.e("TAG", String.valueOf(count));

        fragments(count);

        return view;
    }



    private void fragments(int count) {
        Fragment fragment = null;
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (count==0){
            fragment = new CotizarAutoFragment();
            /*if (transitionCount==0){
                transaction
                transitionCount=1;
            }*/
        }else if (count==1){
            fragment = new CotizarVidaFragment();
        }else if (count==2){
            fragment = new CotizarVidaFragment();
        }

        switch (count){
            case 0:
                btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.car_blanco_button),null,null,null);
                btnSeleccion.setText("AUTO");
                break;
            case 1:
                btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.corazon_blanco_button),null,null,null);
                btnSeleccion.setText("VIDA");
                break;
            case 2:
                btnSeleccion.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.injury_blanco),null,null,null);
                btnSeleccion.setText("GASTOS FUNERARIOS");
                break;
            default:
                break;
        }

        if (fragment != null){
            final Fragment finalFragment = fragment;
            transaction
                    .setCustomAnimations(R.anim.zoom_foward_in,R.anim.zoom_foward_out)
                    .replace(R.id.content_cotiza_compra, finalFragment)
                    .commit();
        }
    }

    public static void Ocultar(boolean ocultar){
        if (ocultar && linearOcultar.getVisibility() == View.VISIBLE){
            linearOcultar.setVisibility(View.GONE);
        }
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
