package com.example.mapapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment  implements OnMapReadyCallback {
    public GoogleMap googleMap;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.googlemap);


        supportMapFragment.getMapAsync(this);
        return view;
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + ":" + latLng.longitude);
                googleMap.clear();
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        latLng,10
                ));



                googleMap.addMarker(markerOptions);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setCompassEnabled(true);
                googleMap.getUiSettings().setRotateGesturesEnabled(true);
                googleMap.getUiSettings().setScrollGesturesEnabled(true);
            }


        });

    }

}