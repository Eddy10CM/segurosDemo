package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frosquivel.magicalcamera.MagicalCamera;

import com.example.clickit.demoseguro.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by clickit on 23/08/16.
 */
public class CambiarAvatarFragment extends Fragment {

    private Activity activity;
    private CircleImageView imagecircle;
    private MagicalCamera magicalCamera;
    private int RESIZE_PHOTO_PIXELS_PERCENTAGE = 3000;
    Intent intent;
    final static int cons  = 0;
    Bitmap bmp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cambiar_avatar,container,false);
        imagecircle = (CircleImageView) view.findViewById(R.id.image_camera);
        /*activity = getActivity();
        magicalCamera = new MagicalCamera(activity,RESIZE_PHOTO_PIXELS_PERCENTAGE);
        */
        imagecircle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,cons);
            }
        });
        return view;
    }

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
        }
    }
}
