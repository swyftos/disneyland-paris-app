package com.google.maps.android.data.kml;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class KmlMultiTrack extends KmlMultiGeometry {
    public KmlMultiTrack(ArrayList<KmlTrack> arrayList) {
        super(createGeometries(arrayList));
    }

    private static ArrayList createGeometries(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            throw new IllegalArgumentException("Tracks cannot be null");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((KmlTrack) it.next());
        }
        return arrayList2;
    }
}
