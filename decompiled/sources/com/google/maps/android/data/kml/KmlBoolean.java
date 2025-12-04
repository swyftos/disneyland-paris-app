package com.google.maps.android.data.kml;

import org.picocontainer.Characteristics;

/* loaded from: classes4.dex */
public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        return "1".equals(str) || Characteristics.TRUE.equals(str);
    }
}
