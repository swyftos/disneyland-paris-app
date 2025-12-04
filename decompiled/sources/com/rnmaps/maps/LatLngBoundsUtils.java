package com.rnmaps.maps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public class LatLngBoundsUtils {
    public static boolean BoundsAreDifferent(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        LatLng center = latLngBounds.getCenter();
        double d = center.latitude;
        double d2 = center.longitude;
        LatLng latLng = latLngBounds.northeast;
        double d3 = latLng.latitude;
        LatLng latLng2 = latLngBounds.southwest;
        double d4 = d3 - latLng2.latitude;
        double d5 = latLng.longitude - latLng2.longitude;
        LatLng center2 = latLngBounds2.getCenter();
        double d6 = center2.latitude;
        double d7 = center2.longitude;
        LatLng latLng3 = latLngBounds2.northeast;
        double d8 = latLng3.latitude;
        LatLng latLng4 = latLngBounds2.southwest;
        double d9 = d8 - latLng4.latitude;
        double d10 = latLng3.longitude - latLng4.longitude;
        double dLatitudeEpsilon = LatitudeEpsilon(latLngBounds, latLngBounds2);
        double dLongitudeEpsilon = LongitudeEpsilon(latLngBounds, latLngBounds2);
        return different(d, d6, dLatitudeEpsilon) || different(d2, d7, dLongitudeEpsilon) || different(d4, d9, dLatitudeEpsilon) || different(d5, d10, dLongitudeEpsilon);
    }

    private static boolean different(double d, double d2, double d3) {
        return Math.abs(d - d2) > d3;
    }

    private static double LatitudeEpsilon(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.northeast.latitude - latLngBounds.southwest.latitude), Math.abs(latLngBounds2.northeast.latitude - latLngBounds2.southwest.latitude)) / 2560.0d;
    }

    private static double LongitudeEpsilon(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.northeast.longitude - latLngBounds.southwest.longitude), Math.abs(latLngBounds2.northeast.longitude - latLngBounds2.southwest.longitude)) / 2560.0d;
    }
}
