package com.example.clickit.demoseguro.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clickit.demoseguro.Fragment.FragmentsNietos.CambiarAvatarFragment;
import com.example.clickit.demoseguro.Fragment.FragmentsNietos.CambiarContasenaFragment;
import com.example.clickit.demoseguro.Fragment.FragmentsNietos.InfoPersonalFragment;
import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 18/08/16.
 */
public class TestFragment3 extends Fragment {

    TextView txtInfoPersonal,txtCambiarAvatar,txtCambiarContrasena;
    int count = 0,transitionCount=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test3,container,false);

        txtInfoPersonal = (TextView)view.findViewById(R.id.txt_info_personal);
        txtCambiarAvatar = (TextView)view.findViewById(R.id.txt_cambiar_avatar);
        txtCambiarContrasena = (TextView)view.findViewById(R.id.txt_cambiar_contrasena);

        fragments(count);

        txtInfoPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInfoPersonal.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                txtInfoPersonal.setTextColor(getResources().getColor(R.color.colorWhite));
                txtCambiarAvatar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtCambiarAvatar.setTextColor(getResources().getColor(R.color.title_fragment));
                txtCambiarContrasena.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtCambiarContrasena.setTextColor(getResources().getColor(R.color.title_fragment));
                count = 0;
                fragments(count);
            }
        });

        txtCambiarAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCambiarAvatar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                txtCambiarAvatar.setTextColor(getResources().getColor(R.color.colorWhite));
                txtInfoPersonal.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtInfoPersonal.setTextColor(getResources().getColor(R.color.title_fragment));
                txtCambiarContrasena.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtCambiarContrasena.setTextColor(getResources().getColor(R.color.title_fragment));
                count = 1;
                fragments(count);
            }
        });

        txtCambiarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCambiarContrasena.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                txtCambiarContrasena.setTextColor(getResources().getColor(R.color.colorWhite));
                txtCambiarAvatar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtCambiarAvatar.setTextColor(getResources().getColor(R.color.title_fragment));
                txtInfoPersonal.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txtInfoPersonal.setTextColor(getResources().getColor(R.color.title_fragment));
                count = 2;
                fragments(count);
            }
        });
        return view;
    }

    private void fragments(int count) {
        Fragment fragment = null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (count==0){
            fragment = new InfoPersonalFragment();
            /*if (transitionCount==0){
                transaction
                transitionCount=1;
            }*/
        }else if (count==1){
            fragment = new CambiarAvatarFragment();
        }else if (count==2){
            fragment = new CambiarContasenaFragment();
        }

        if (fragment != null){
            transaction
                    .setCustomAnimations(R.anim.zoom_foward_in,R.anim.zoom_foward_out)
                    .replace(R.id.content_configuration,fragment)
                    .commit();
        }
    }
}
