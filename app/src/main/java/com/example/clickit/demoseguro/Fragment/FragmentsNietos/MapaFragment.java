package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.clickit.demoseguro.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by root on 6/09/16.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return view;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(25.644525, -100.324120), 16));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.644525, -100.324120)).title("Odessa"));
    }

    /*public class RootLayout extends RelativeLayout{
        public RootLayout(Context context) {
            super(context);
        }

        public RootLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public RootLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            final int action = ev.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    //Log.i("CustomScrollView", "onInterceptTouchEvent: DOWN super false" );
                    super.onTouchEvent(ev);
                    break;

                case MotionEvent.ACTION_MOVE:
                    return false; // redirect MotionEvents to ourself

                case MotionEvent.ACTION_CANCEL:
                    // Log.i("CustomScrollView", "onInterceptTouchEvent: CANCEL super false" );
                    super.onTouchEvent(ev);
                    break;

                case MotionEvent.ACTION_UP:
                    //Log.i("CustomScrollView", "onInterceptTouchEvent: UP super false" );
                    return false;

                default:
                    //Log.i("CustomScrollView", "onInterceptTouchEvent: " + action );
                    break;
            }

            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            super.onTouchEvent(ev);
            //Log.i("CustomScrollView", "onTouchEvent. action: " + ev.getAction() );
            return true;
        }
    }*/
}
