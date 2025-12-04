package com.google.maps.android.data;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public class Point implements Geometry {
    private final LatLng mCoordinates;

    public Point(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = latLng;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return "Point";
    }

    @Override // com.google.maps.android.data.Geometry
    public LatLng getGeometryObject() {
        return this.mCoordinates;
    }

    @NonNull
    public String toString() {
        return "Point{\n coordinates=" + this.mCoordinates + "\n}\n";
    }
}
