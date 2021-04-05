package com.example.movicelselfcare.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.movicelselfcare.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class FragmentStore extends Fragment implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    MapView mMapView;
    private GoogleMap mGoogleMap;
    private TextView mTextViewSearch;
    private SupportMapFragment mSupportMapFragment;
    private LocationManager locationManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mSupportMapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mSupportMapFragment).commit();
        }

        mTextViewSearch = view.findViewById(R.id.search);

        mTextViewSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    String locationName = mTextViewSearch.getText().toString();
                    if (locationName != null && !locationName.equalsIgnoreCase("")) {
                        Geocoder gc = new Geocoder(getActivity());
                        List<Address> addressList;
                        try {
                            addressList = gc.getFromLocationName(locationName, 5);

                            if (addressList != null && addressList.size() != 0) {
                                Address address = addressList.get(0);

                                mGoogleMap.clear();

                                mGoogleMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(address.getLatitude(), address.getLongitude())));
                                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(address.getLatitude(), address.getLongitude()), 11));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return true;
                }
                return false;
            }
        });

        if (mSupportMapFragment != null) {

            Log.d("test", "map fragment is  not null");
            mSupportMapFragment.getMapAsync(this);

        } else {

            Log.d("test", "map fragment is null");
        } // needed to get the map to display immediately
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("test", "Onmap ready called");

        mGoogleMap = googleMap;

        mGoogleMap.clear();

        mGoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-8.814173, 13.226166)));

        mGoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-8.8749875,13.2429341)));

//        mGoogleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(-12.396539, 17.667818)));
//
//        mGoogleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(-11.754635, 16.920747)));

        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-8.814173, 13.226166), 11));
    }
}