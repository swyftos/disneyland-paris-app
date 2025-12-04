package com.google.maps.android.data.kml;

import androidx.annotation.NonNull;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class KmlMultiGeometry extends MultiGeometry {
    public KmlMultiGeometry(ArrayList<Geometry> arrayList) {
        super(arrayList);
    }

    @Override // com.google.maps.android.data.MultiGeometry, com.google.maps.android.data.Geometry
    public ArrayList<Geometry> getGeometryObject() {
        return new ArrayList<>(super.getGeometryObject());
    }

    @Override // com.google.maps.android.data.MultiGeometry
    @NonNull
    public String toString() {
        return getGeometryType() + "{\n geometries=" + getGeometryObject() + "\n}\n";
    }
}
