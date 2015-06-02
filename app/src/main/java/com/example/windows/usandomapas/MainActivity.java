package com.example.windows.usandomapas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends ActionBarActivity {
    private GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar el fragmento en donde se mostrara el mapa
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa)).getMap();

            //Cambiar el tipo de mapa
           googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //Mostrar u ocultar tu ubicacion
            googleMap.setMyLocationEnabled(true);

            //Mostrar u ocultar botones de zoom
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            //Mostrar u ocultar boton de localizacion
            googleMap.getUiSettings().setCompassEnabled(true);

            //Mostrar ocultar icono de compas
            googleMap.getUiSettings().setCompassEnabled(true);

            //Mostrar/ocultar evento de rotar
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            //Mostrar/ocultar funcionalidad del zomm
            googleMap.getUiSettings().setZoomGesturesEnabled(true);


            double latitude = 18.3543592;
            double longitude = -100.6754476;

            //Crear marcador
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title(getString(R.string.casa));

            //Agregar color al marcador
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

            //agregar marker
            googleMap.addMarker(marker);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            //En caso de clic cambiar tipo de mapa a satelital
            case R.id.sat:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            //En caso de clic cambiar tipo de mapa a hibrido
            case R.id.hib:
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            //En caso de clic cambiar tipo de mapa a terreno
            case R.id.ter:
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            //En caso de clic cambiar tipo de mapa a nomal
            case R.id.nor:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            //En caso de clic cambiar tipo de mapa a ninguno
            case R.id.none:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
            //En caso de clic ir al marcador
            case R.id.irmarcador:
                gomarker();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void gomarker(){
        //MEtodo que crea la animacion para visualizar el marcador
        if (googleMap.getMyLocation() != null)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
            new LatLng(googleMap.getMyLocation().getLatitude(), googleMap.getMyLocation().getLongitude()), 17));
    }

}
