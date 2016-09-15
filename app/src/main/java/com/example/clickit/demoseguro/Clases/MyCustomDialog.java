package com.example.clickit.demoseguro.Clases;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.clickit.demoseguro.R;

/**
 * Created by clickit on 14/09/16.
 */
public class MyCustomDialog extends Dialog implements View.OnClickListener{

    public static final String TAG = MyCustomDialog.class.getSimpleName();
    public Button btnVolver;
    int position;


    public MyCustomDialog(Context context,int position) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_data);
        btnVolver = (Button)findViewById(R.id.back);
        btnVolver.setOnClickListener(this);
        Log.e(TAG,String.valueOf(position));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Log.e(TAG, " Is pressed");
                dismiss();
                break;
            default:
                break;
        }
        //dismiss();
    }
}
