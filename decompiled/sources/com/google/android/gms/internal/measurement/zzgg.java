package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes3.dex */
abstract class zzgg {
    private static final zzgg zza;
    private static final zzgg zzb;

    private zzgg() {
    }

    abstract List zza(Object obj, long j);

    abstract void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzgg zza() {
        return zza;
    }

    static zzgg zzb() {
        return zzb;
    }

    static {
        zzgj zzgjVar = null;
        zza = new zzgi();
        zzb = new zzgl();
    }
}
