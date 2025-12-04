package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* loaded from: classes3.dex */
public final class zzcw {
    private static final ArrayMap zza = new ArrayMap();

    public static synchronized Uri zza(String str) {
        Uri uri;
        try {
            ArrayMap arrayMap = zza;
            uri = (Uri) arrayMap.get(str);
            if (uri == null) {
                String strValueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
                arrayMap.put(str, uri);
            }
        } catch (Throwable th) {
            throw th;
        }
        return uri;
    }
}
