package com.example.mapapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity {

    Fragment fragment= new MapFragment();
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)==
                PackageManager.PERMISSION_GRANTED){
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.framelayout,fragment)
                    .commit();




        } else{
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44 );
        }




    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getSupportFragmentManager().
                        beginTransaction()
                        .replace(R.id.framelayout,fragment)
                        .commit();


            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId()==R.id.noneMap)
        {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        }
        if (item.getItemId()==R.id.NormalMap)
        {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        if (item.getItemId()==R.id.SatelliteMap)
        {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        if (item.getItemId()==R.id.MapHybrid)
        {
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
        if (item.getItemId()==R.id.terrain)
        {
            googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
        return super.onOptionsItemSelected(item);

    }
}