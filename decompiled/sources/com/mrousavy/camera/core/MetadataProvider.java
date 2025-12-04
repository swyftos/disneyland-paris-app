package com.mrousavy.camera.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001b\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/mrousavy/camera/core/MetadataProvider;", "Landroid/location/LocationListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "locationManager", "Landroid/location/LocationManager;", "hasLocationPermission", "", "getHasLocationPermission", "()Z", "value", "Landroid/location/Location;", "location", "getLocation", "()Landroid/location/Location;", "enableLocationUpdates", "", "enable", "onLocationChanged", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MetadataProvider implements LocationListener {
    private final Context context;
    private Location location;
    private final LocationManager locationManager;

    public MetadataProvider(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    private final boolean getHasLocationPermission() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    @Nullable
    public final Location getLocation() {
        return this.location;
    }

    @SuppressLint({"MissingPermission"})
    public final void enableLocationUpdates(boolean enable) throws LocationPermissionError {
        if (!enable) {
            Log.i("MetadataProvider", "Stopping location updates...");
            this.locationManager.removeUpdates(this);
        } else {
            if (getHasLocationPermission()) {
                Log.i("MetadataProvider", "Start updating location...");
                this.locationManager.requestLocationUpdates("gps", 5000L, 5.0f, this);
                Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
                this.location = lastKnownLocation;
                if (lastKnownLocation == null) {
                    this.locationManager.requestSingleUpdate("gps", this, (Looper) null);
                    return;
                }
                return;
            }
            throw new LocationPermissionError();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Log.i("MetadataProvider", "Location updated: " + location.getLatitude() + ", " + location.getLongitude());
        this.location = location;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i("MetadataProvider", "Location Provider " + provider + " has been disabled.");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i("MetadataProvider", "Location Provider " + provider + " has been enabled.");
    }

    @Override // android.location.LocationListener
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "", imports = {""}))
    public void onStatusChanged(@Nullable String provider, int status, @Nullable Bundle extras) {
        Log.i("MetadataProvider", "Location Provider " + provider + " status changed: " + status);
    }
}
