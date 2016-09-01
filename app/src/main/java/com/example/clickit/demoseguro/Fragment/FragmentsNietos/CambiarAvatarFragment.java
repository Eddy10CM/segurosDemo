package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clickit.demoseguro.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by clickit on 23/08/16.
 */
public class CambiarAvatarFragment extends Fragment {

    private Activity activity;
    private CircleImageView imagecircle;
    private static final int REQUEST_CAPTURE = 1;
    private File imageFile;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();

        PackageManager packageManager = activity.getPackageManager();

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false){
            Toast.makeText(getActivity(),"This device doesn't have a camera",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(),"This device have a camera",Toast.LENGTH_SHORT).show();
        }

        View view = inflater.inflate(R.layout.fragment_cambiar_avatar,container,false);

        imagecircle = (CircleImageView) view.findViewById(R.id.image_camera);

        imagecircle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                launchCamera(v);
            }

        });

        return view;
    }

    public void launchCamera(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Test.jpg");
        Uri tempUri = Uri.fromFile(imageFile)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,value);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY);
        startActivityForResult(intent, REQUEST_CAPTURE);
    }


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CAPTURE && resultCode == activity.RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            imagecircle.setImageBitmap(photo);
        }
    }*/
}
