package com.rnmaps.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class FusedLocationSource implements LocationSource {
    private final FusedLocationProviderClient fusedLocationClientProviderClient;
    private LocationCallback locationCallback;
    private final LocationRequest locationRequest;

    public FusedLocationSource(Context context) {
        this.fusedLocationClientProviderClient = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        locationRequestCreate.setInterval(5000L);
    }

    public void setPriority(int i) {
        this.locationRequest.setPriority(i);
    }

    public void setInterval(int i) {
        this.locationRequest.setInterval(i);
    }

    public void setFastestInterval(int i) {
        this.locationRequest.setFastestInterval(i);
    }

    @Override // com.google.android.gms.maps.LocationSource
    @SuppressLint({"MissingPermission"})
    public void activate(final LocationSource.OnLocationChangedListener onLocationChangedListener) {
        try {
            this.fusedLocationClientProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener() { // from class: com.rnmaps.maps.FusedLocationSource.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(Location location) {
                    if (location != null) {
                        onLocationChangedListener.onLocationChanged(location);
                    }
                }
            });
            LocationCallback locationCallback = new LocationCallback() { // from class: com.rnmaps.maps.FusedLocationSource.2
                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationResult(LocationResult locationResult) {
                    Iterator<Location> it = locationResult.getLocations().iterator();
                    while (it.hasNext()) {
                        onLocationChangedListener.onLocationChanged(it.next());
                    }
                }
            };
            this.locationCallback = locationCallback;
            this.fusedLocationClientProviderClient.requestLocationUpdates(this.locationRequest, locationCallback, Looper.myLooper());
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.android.gms.maps.LocationSource
    public void deactivate() {
        this.fusedLocationClientProviderClient.removeLocationUpdates(this.locationCallback);
    }
}
