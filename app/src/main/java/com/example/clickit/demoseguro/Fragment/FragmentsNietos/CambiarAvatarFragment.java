package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
<<<<<<< HEAD
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
=======
import android.graphics.Bitmap;
import android.os.Bundle;
>>>>>>> d5515c727215297340c1fe2b0011d59289bee964
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
<<<<<<< HEAD
    private static final int REQUEST_CAPTURE = 1;
    private File imageFile;

=======
    private MagicalCamera magicalCamera;
    private int RESIZE_PHOTO_PIXELS_PERCENTAGE = 3000;
    Intent intent;
    final static int cons  = 0;
    Bitmap bmp;
>>>>>>> d5515c727215297340c1fe2b0011d59289bee964

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        activity = getActivity();

        PackageManager packageManager = activity.getPackageManager();

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false){
            Toast.makeText(getActivity(),"This device doesn't have a camera",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(),"This device have a camera",Toast.LENGTH_SHORT).show();
        }

=======
>>>>>>> d5515c727215297340c1fe2b0011d59289bee964
        View view = inflater.inflate(R.layout.fragment_cambiar_avatar,container,false);
        imagecircle = (CircleImageView) view.findViewById(R.id.image_camera);
        /*activity = getActivity();
        magicalCamera = new MagicalCamera(activity,RESIZE_PHOTO_PIXELS_PERCENTAGE);
        */
        imagecircle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
<<<<<<< HEAD
                launchCamera(v);
=======
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,cons);
>>>>>>> d5515c727215297340c1fe2b0011d59289bee964
            }

        });
        return view;
    }

<<<<<<< HEAD
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
=======
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        /*magicalCamera.resultPhoto(requestCode, resultCode, data);
        imagecircle.setImageBitmap(magicalCamera.getMyPhoto());
        //magicalCamera.savePhotoInMemoryDevice(magicalCamera.getMyPhoto(), "myTestPhoto", MagicalCamera.JPEG, true);

        if(magicalCamera.savePhotoInMemoryDevice(magicalCamera.getMyPhoto(), "myTestPhoto", MagicalCamera.JPEG, true)){
            Toast.makeText(activity, "The photo is save", Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(activity, "The photo isn't save",Toast.LENGTH_SHORT);
        }*/
        if (resultCode==Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap)extras.get("data");
            imagecircle.setImageBitmap(bmp);
>>>>>>> d5515c727215297340c1fe2b0011d59289bee964
        }
    }
}
