package com.example.clickit.demoseguro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.clickit.demoseguro.Fragment.AcercaFragment;
import com.example.clickit.demoseguro.Fragment.ContactoFragment;
import com.example.clickit.demoseguro.Fragment.CotizaCompraFragment;
import com.example.clickit.demoseguro.Fragment.InicioFragment;
import com.example.clickit.demoseguro.Fragment.InvitaUnAmigoFragment;
import com.example.clickit.demoseguro.Fragment.PolizasFragment;

public class DrawerActivity extends AppCompatActivity {


        //implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        toolbar.setTitle(R.string.inicio);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        if(navigationView != null){
            prepararDrawer(navigationView);
            selccionarItem(navigationView.getMenu().getItem(0));
        }
    }

    private void selccionarItem(MenuItem item) {
        Fragment fragmentGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (item.getItemId()){
            case R.id.nav_inicio:
                fragmentGenerico = new InicioFragment();
                break;
            case R.id.nav_cotiza_compra:
                fragmentGenerico = new CotizaCompraFragment();
                break;
            case R.id.nav_polizas:
                fragmentGenerico = new PolizasFragment();
                break;
            case R.id.nav_invita:
                fragmentGenerico = new InvitaUnAmigoFragment();
                break;
            case R.id.nav_acerca:
                fragmentGenerico = new AcercaFragment();
                break;
            case R.id.nav_contacto:
                fragmentGenerico = new ContactoFragment();
                break;
            case R.id.nav_logout:
                finish();
                break;

        }
        if (fragmentGenerico != null){
            fragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.left_in,R.anim.left_out)
                    .replace(R.id.contenedor_principal,fragmentGenerico)
                    .commit();

        }
        setTitle(item.getTitle());
    }

    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                selccionarItem(item);
                drawer.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            toolbar.setTitle(R.string.inicio);
        } else if (id == R.id.nav_cotiza_compra) {
            toolbar.setTitle(R.string.cotiza_compra);
        } else if (id == R.id.nav_polizas) {
            toolbar.setTitle(R.string.polizas);
        } else if (id == R.id.nav_invita) {
            toolbar.setTitle(R.string.friends);
        } else if (id == R.id.nav_acerca) {
            toolbar.setTitle(R.string.about);
        } else if (id == R.id.nav_contacto) {
            toolbar.setTitle(R.string.contact);
        }else if (id == R.id.nav_logout){
            toolbar.setTitle(R.string.logout);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/



}
