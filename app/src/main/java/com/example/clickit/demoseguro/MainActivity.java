package com.example.clickit.demoseguro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnInicio = (Button)findViewById(R.id.login);
        isReadStorageAllowed();
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DrawerActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.zoom_foward_in,R.anim.zoom_foward_out);
            }
        });
    }

    private boolean isReadStorageAllowed(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else {
            requestStoragePermission();
            return false;
        }
    }

    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.INTERNET) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission

        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION},STORAGE_PERMISSION_CODE);
    }

    @Override
    @SuppressWarnings({"ResourceType"})
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if(requestCode == STORAGE_PERMISSION_CODE){

            //If permission is granted
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                //Displaying a toast
                Toast.makeText(this,"Permission granted now you can read the storage",Toast.LENGTH_LONG).show();
            }else{
                //Displaying another toast if permission is not granted
                Toast.makeText(this,"Oops you just denied the permission",Toast.LENGTH_LONG).show();
            }
        }
    }


}
