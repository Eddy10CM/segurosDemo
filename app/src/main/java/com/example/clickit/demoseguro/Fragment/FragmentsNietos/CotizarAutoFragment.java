package com.example.clickit.demoseguro.Fragment.FragmentsNietos;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.clickit.demoseguro.Adapters.AdaptadorListaSpinnerAutos;
import com.example.clickit.demoseguro.Adapters.ExpandAndCollapseViewUtil;
import com.example.clickit.demoseguro.Clases.Global;
import com.example.clickit.demoseguro.Clases.ListaAutos;
import com.example.clickit.demoseguro.Clases.MyCustomToast;
import com.example.clickit.demoseguro.Clases.RecyclerItemClickListener;
import com.example.clickit.demoseguro.Fragment.CotizaCompraFragment;
import com.example.clickit.demoseguro.Fragment.CotizaFragment;
import com.example.clickit.demoseguro.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by clickit on 29/08/16.
 */
public class CotizarAutoFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    Button btnSpinner,btnCerrarBack;
    ViewGroup lista;
    TextView txtCambia;

    private String [] modelos;
    private String [] marca;
    private String [] linea;
    private String [] descripcion;
    private ArrayList<ListaAutos> listaAutoses = new ArrayList<>();
    private static final int DURATION = 250;
    private LinearLayoutManager linearLayoutManager;
    RecyclerView listaAutos;
    int count = 0;
    String modeloAuto,marcaAuto,lineaAuto;
    private AdaptadorListaSpinnerAutos adapter;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private String URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    private static String TAG = CotizarAutoFragment.class.getSimpleName();
    private String latitud ="",longitud="";
    private EditText editTextCP;
    private boolean isPressed = false;
    private Button btnMostrarOfertas;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotiza_auto,container,false);

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        btnSpinner = (Button)view.findViewById(R.id.spinner_autos);

        lista = (ViewGroup)view.findViewById(R.id.collapsable_list);
        txtCambia = (TextView)view.findViewById(R.id.txt_cambia);
        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count==4){
                    btnSpinner.setText(modeloAuto + " " + marcaAuto + " " + lineaAuto);
                    btnCerrarBack.setText("Linea");
                    txtCambia.setText("Descripción");
                    adapter.clear();
                    for (int i=0; i<descripcion.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(descripcion[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    btnSpinner.setCompoundDrawablesWithIntrinsicBounds(null,null,getActivity().getResources().getDrawable(R.drawable.arrow_black),null);
                    count = 3;
                }
                if (isPressed==false){
                    ExpandAndCollapseViewUtil.expand(lista, DURATION);
                    isPressed=true;
                }
                Log.e("TAG",String.valueOf(count));
            }
        });

        btnCerrarBack = (Button)view.findViewById(R.id.btn_cerrar_and_back);

        btnCerrarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG",String.valueOf(count));
                if (count==0){
                    if (isPressed==true){
                        ExpandAndCollapseViewUtil.collapse(lista, DURATION);
                        isPressed=false;
                    }
                }
                if (count==1){
                    btnSpinner.setText("Selecciona Vehículo");
                    btnCerrarBack.setText("Cerrar");
                    btnCerrarBack.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.close),null,null,null);
                    txtCambia.setText("Modelo");
                    adapter.clear();
                    for (int i=0; i<modelos.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(modelos[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 0;
                }
                if (count==2){
                    btnSpinner.setText(modeloAuto);
                    btnCerrarBack.setText("Modelo");
                    txtCambia.setText("Marca");
                    adapter.clear();
                    for (int i=0; i<marca.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(marca[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 1;
                }
                if (count==3){
                    btnSpinner.setText(modeloAuto + " " + marcaAuto);
                    btnCerrarBack.setText("Marca");
                    txtCambia.setText("Linea");
                    adapter.clear();
                    for (int i=0; i<linea.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(linea[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 2;
                }
            }
        });

        listaAutos = (RecyclerView)view.findViewById(R.id.items_seleccionables);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listaAutos.setLayoutManager(linearLayoutManager);
        adapter = new AdaptadorListaSpinnerAutos(getActivity());
        listaAutos.setAdapter(adapter);
        modelos = getActivity().getResources().getStringArray(R.array.modelos);
        marca = getActivity().getResources().getStringArray(R.array.marcas);
        linea = getActivity().getResources().getStringArray(R.array.lineas);
        descripcion = getActivity().getResources().getStringArray(R.array.descripcion);

        for (int i=0; i<modelos.length; i++){
            ListaAutos test = new ListaAutos();
            test.setLista(modelos[i]);
            listaAutoses.add(test);
        }
        adapter.setItems(listaAutoses);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getActivity().getResources().getString(R.string.mensaje));
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        listaAutos.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View childView, int position) {
                ListaAutos items = listaAutoses.get(position);
                if (count==0){
                    btnSpinner.setText(items.getLista());
                    modeloAuto = items.getLista();
                    btnCerrarBack.setText("Modelo");
                    btnCerrarBack.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(R.drawable.back),null,null,null);
                    txtCambia.setText("Marca");
                    adapter.clear();
                    for (int i=0; i<marca.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(marca[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 1;
                }else if (count==1){
                    String queTieneElBoton = btnSpinner.getText().toString();
                    marcaAuto = items.getLista();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnCerrarBack.setText("Marca");
                    txtCambia.setText("Línea");

                    adapter.clear();
                    for (int i=0; i<linea.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(linea[i]);
                        listaAutoses.add(test);
                    }
                    adapter.setItems(listaAutoses);
                    count = 2;
                }else if (count==2){
                    String queTieneElBoton = btnSpinner.getText().toString();
                    lineaAuto = items.getLista();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnCerrarBack.setText("Línea");
                    txtCambia.setText("Descripción");
                    adapter.clear();
                    for (int i=0; i<descripcion.length;i++){
                        ListaAutos test = new ListaAutos();
                        test.setLista(descripcion[i]);
                        listaAutoses.add(test);
                    }
                    Log.e("TAG",String.valueOf(count));
                    adapter.setItems(listaAutoses);
                    count = 3;
                }else if (count==3){
                    Log.e("TAG",String.valueOf(count));
                    String queTieneElBoton = btnSpinner.getText().toString();
                    btnSpinner.setText(queTieneElBoton + " " +items.getLista());
                    btnSpinner.setCompoundDrawablesWithIntrinsicBounds(null,null,getActivity().getResources().getDrawable(R.drawable.ok_bien),null);
                    btnCerrarBack.setText("Línea");
                    txtCambia.setText("Descripción");
                    ExpandAndCollapseViewUtil.collapse(lista,DURATION);
                    count = 4;
                    isPressed=false;
                }
            }

            @Override
            public void onItemLongPress(View childView, int position) {

            }
        }));

        editTextCP = (EditText)view.findViewById(R.id.edit_cp);

        btnMostrarOfertas = (Button)view.findViewById(R.id.btn_mostrar_ofertas);
        btnMostrarOfertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = btnSpinner.getText().toString();
                String cp = editTextCP.getHint().toString();
                if (dato.equals("Selecciona tu vehículo") && cp.equals("C.P")){
                    MyCustomToast toast = new MyCustomToast(getActivity().getApplicationContext(),Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,50);
                    toast.show("Capture todos los datos seleccionados");
                }else{
                    CotizaCompraFragment.Ocultar(true);
                    Fragment fragment = new CotizaFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    if (fragment != null){
                        transaction
                                .setCustomAnimations(R.anim.zoom_foward_in,R.anim.zoom_foward_out)
                                .replace(R.id.content_cotiza_compra, fragment)
                                .commit();
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null){
            latitud = String.valueOf(mLastLocation.getLatitude());
            longitud = String.valueOf(mLastLocation.getLongitude());
            Log.e(TAG,latitud);
            Log.e(TAG,longitud);
            if (latitud.equals(" ") || latitud.equals(null) && longitud.equals(" ") || longitud.equals(null)){
            }else {
                objectRequest();
            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(),"Ubicacion no encontrada",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void objectRequest(){
        //Log.e(TAG,URL+"latlng="+latitud+","+longitud+"&key="+getActivity().getResources().getString(R.string.api_key_google));
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL+"latlng="+latitud+","+longitud+"&key="+getActivity().getResources().getString(R.string.api_key_google), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, response.toString());
                try {
                    //Log.e(TAG,response.getString("status"));
                    /*if (response.getString("status").equals("ZERO_RESULTS")){
                        //segundoRequest();
                    }else if (response.getString("result")!=null){

                    }*/
                    JSONArray results = response.getJSONArray("results");
                    //Log.e(TAG, results.toString());
                    if (results!=null){

                        //Log.e(TAG,results.toString());
                        //for (int i =0; i<results.length();i++){
                            JSONObject item = results.getJSONObject(0);
                            //Log.e(TAG + i,item.toString());
                            //Log.e(TAG,item.getString("address_components"));
                            JSONArray array = item.getJSONArray("address_components");
                            //JSONArray components = item.getJSONArray("address_components");
                            //JSONObject components = item.getJSONObject("address_components");
                            //Log.e(TAG ,array.toString());
                        for (int i = 0; i<array.length();i++){
                            JSONObject components = array.getJSONObject(i);
                            switch (i){
                                case 0:
                                    Log.e(TAG + "street_number",components.getString("long_name"));
                                    break;
                                case 1:
                                    Log.e(TAG + "route",components.getString("long_name"));
                                    break;
                                case 2:
                                    Log.e(TAG + "political",components.getString("long_name"));
                                    break;
                                case 3:
                                    Log.e(TAG + "locality",components.getString("long_name"));
                                    break;
                                case 4:
                                    Log.e(TAG + "arealevel2",components.getString("long_name"));
                                    break;
                                case 5:
                                    Log.e(TAG + "area_level_1",components.getString("long_name"));
                                    break;
                                case 6:
                                    Log.e(TAG + "country",components.getString("short_name"));
                                    break;
                                case 7:
                                    Log.e(TAG + "postal_code",components.getString("long_name"));
                                    editTextCP.setText(components.getString("long_name"));

                                    break;
                                default:
                                    break;
                            }
                            Log.e(TAG,String.valueOf(i));
                        }
                            /*for (int j=0; j<components.length();j++){
                                Log.e(TAG + "components",components.getString(0));
                                Log.e(TAG + "components",components.getString(1));
                                Log.e(TAG + "components",components.getString(2));
                            }*/
                        //}
                        //Log.e(TAG + "response" ,results.get(1).toString());
                        //JSONArray address_componets = results.getJSONArray("address_components");
                        //JSONArray array = item.getJSONArray("postal_code");
                        //Log.e(TAG,item.toString());
                        if (array.length()<8){
                            progressDialog.dismiss();
                            Toast.makeText(getActivity().getApplicationContext(),getActivity().getResources().getString(R.string.mensaje1),Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(getActivity().getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("SEGUNDO ERROR", error.toString());
            }
        });

        RetryPolicy policy = new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjectRequest.setRetryPolicy(policy);
        Global.getInstance().addToRequestQueue(jsonObjectRequest, TAG);
    }

    /*private void segundoRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL+"latlng="+latitud+","+longitud+"&key="+getActivity().getResources().getString(R.string.api_key_google)+"&result_type=postal_code", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //Log.e(TAG + 1, response.toString());
                try {
                    Log.e(TAG,response.getString("status"));
                    if (response.getString("status").equals("ZERO_RESULTS")){
                        segundoRequest();
                    }else{
                        JSONArray results = response.getJSONArray("result");
                        Log.e(TAG,results.get(0).toString());
                        /*for (int i =0; i<results.length();i++){
                            JSONObject item = results.getJSONObject(i);
                            Log.e(TAG + i,item.getString("address_components"));
                        }*/
                        //Log.e(TAG + "response" ,results.get(1).toString());
                        //JSONArray address_componets = results.getJSONArray("address_components");
                        //JSONArray array = item.getJSONArray("postal_code");
                        //Log.e(TAG,item.toString());
                   /* }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("SEGUNDO ERROR", error.toString());
            }
        });

        RetryPolicy policy = new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjectRequest.setRetryPolicy(policy);
        Global.getInstance().addToRequestQueue(jsonObjectRequest, TAG);
    }*/
}
