package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes3.dex */
public final class zzxb {
    private static zzxb zza;

    private zzxb() {
    }

    public static synchronized zzxb zza() {
        try {
            if (zza == null) {
                zza = new zzxb();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
