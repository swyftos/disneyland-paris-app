package com.google.maps.android.data;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* loaded from: classes4.dex */
public class LineString implements Geometry<List<LatLng>> {
    private final List mCoordinates;

    public LineString(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = list;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return "LineString";
    }

    @Override // com.google.maps.android.data.Geometry
    public List<LatLng> getGeometryObject() {
        return this.mCoordinates;
    }

    @NonNull
    public String toString() {
        return "LineString{\n coordinates=" + this.mCoordinates + "\n}\n";
    }
}
