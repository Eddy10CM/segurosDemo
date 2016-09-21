package com.example.clickit.demoseguro.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clickit.demoseguro.Fragment.FragmentsNietos.CambiarAvatarFragment;
import com.example.clickit.demoseguro.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.clickit.demoseguro.R.color.colorPrimary;

public class InicioFragment extends Fragment {


    int count = 0;
    int transitions_fragment1 = 0,transitions_fragment2 = 0, transitions_fragment3 = 0;
    public InicioFragment(){}
    private CircleImageView imageViewAvatar;
    final static int cons  = 0;
    private Drawable imagenAnteroir;
    Button btnActualizar,btnCancelar;
    Intent intent;
    Bitmap bmp;

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

        btnActualizar = (Button)view.findViewById(R.id.btn_actualizar);

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

        imageViewAvatar = (CircleImageView) view.findViewById(R.id.img_cambiar_avatar);
        imageViewAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagenAnteroir = imageViewAvatar.getDrawable();
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,cons);
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnActualizar.getVisibility() == View.VISIBLE){
                    btnActualizar.setVisibility(View.GONE);
                    btnCancelar.setVisibility(View.GONE);
                }
            }
        });

        btnCancelar = (Button)view.findViewById(R.id.btn_cancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewAvatar.setImageDrawable(imagenAnteroir);
                btnActualizar.setVisibility(View.GONE);
                btnCancelar.setVisibility(View.GONE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            imageViewAvatar.setImageBitmap(bmp);
            btnActualizar.setVisibility(View.VISIBLE);
            btnCancelar.setVisibility(View.VISIBLE);
        }
    }

    private void fragments(int count) {
        Fragment fragment = null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (count == 0){
            fragment = new TestFragment();
            if (transitions_fragment1==0){
                transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out);
                transitions_fragment1 = 2;
                transitions_fragment3 = 1;
            }else if (transitions_fragment1 == 1){
                transaction.setCustomAnimations(R.anim.right_in,R.anim.right_out);
                transitions_fragment1 =2;
            }else if (transitions_fragment1 == 2){
            }
            transitions_fragment2 = 0;
        }else if (count == 1){
            fragment = new TestFragment2();
            if (transitions_fragment2 == 0){
                transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out);
                transitions_fragment2 = 2;
                transitions_fragment3 = 0;
            }else if (transitions_fragment2 == 1){
                transaction.setCustomAnimations(R.anim.right_in,R.anim.right_out);
                transitions_fragment2 =0;
            }else if (transitions_fragment2 == 2){
            }
            transitions_fragment1 = 1;
        }else if (count == 2){
            fragment = new TestFragment3();
            if (transitions_fragment3 == 0){
                transaction.setCustomAnimations(R.anim.left_in,R.anim.left_out);
                transitions_fragment3 = 2;
            }else if (transitions_fragment3 == 1){
                transaction.setCustomAnimations(R.anim.right_in,R.anim.right_out);
                transitions_fragment3 =2;
            }else if (transitions_fragment3 == 2){
            }
            transitions_fragment1 = 0;
            transitions_fragment2 = 1;
        }
        if (fragment!=null){
            transaction.replace(R.id.content,fragment)
            .commit();
            //transaction.add(R.id.content,fragment).addToBackStack(null).commit();
        }
    }
}
