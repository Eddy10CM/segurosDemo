package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.clickit.demoseguro.Adapters.AdaptadorSlider;
import com.example.clickit.demoseguro.DrawerActivity;
import com.example.clickit.demoseguro.R;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by clickit on 16/08/16.
 */
public class TestFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private  int count = 3;
    CircleImageView btnMisPolizas;
    Button btnTest;
    private Fragment fragment = null;
    private FragmentTransaction transaction;

    private TextSliderView textSliderView;
    public TestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,container,false);

        mDemoSlider = (SliderLayout)view.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("", "http://misseguros.odessaseguros.com/images/carruselinicio/vida.jpg");
        url_maps.put("Cotiza tu automovil hasta con 6 aseguradoras", "http://misseguros.odessaseguros.com/images/carruselinicio/Car.jpeg");
        url_maps.put("Sin la preocupacion de gastos en los momentos de dolor", "http://misseguros.odessaseguros.com/images/carruselinicio/funeral.jpg");

        HashMap<String,String> btnName = new HashMap<>();
        btnName.put("name","cotiza");
        btnName.put("name","cotiza");
        btnName.put("name","cotiza");

        btnTest = (Button)view.findViewById(R.id.button);

        btnMisPolizas = (CircleImageView)view.findViewById(R.id.btn_mis_polizas);

        for(final String name : url_maps.keySet()){
            textSliderView = new TextSliderView(getActivity());

            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);



            mDemoSlider.addSlider(textSliderView);

        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(TestFragment.this);




        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mDemoSlider.getCurrentPosition()){
                    case 0:
                        Log.e("TAG","POSICION " + mDemoSlider.getCurrentPosition());
                        //activity.selccionarItem(navigationView.getMenu().getItem(1));
                        fragment = new CotizaCompraFragment(0);
                        transaction = getFragmentManager().beginTransaction();
                        break;
                    case 1:
                        Log.e("TAG","POSICION " + mDemoSlider.getCurrentPosition());
                        fragment = new CotizaCompraFragment(1);
                        transaction = getFragmentManager().beginTransaction();
                        break;
                    case 2:
                        Log.e("TAG","POSICION " + mDemoSlider.getCurrentPosition());
                        fragment = new CotizaCompraFragment(2);
                        transaction = getFragmentManager().beginTransaction();
                        break;
                }
                if (fragment!=null){
                    transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out)
                            .replace(R.id.contenedor_principal,fragment)
                            .commit();
                    //transaction.add(R.id.content,fragment).addToBackStack(null).commit();
                }
            }
        });

        btnMisPolizas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG "," Is pressed");
                Fragment fragment = new PolizasFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if (fragment!=null){
                    transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out)
                            .replace(R.id.contenedor_principal,fragment)
                            .commit();
                    //transaction.add(R.id.content,fragment).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
