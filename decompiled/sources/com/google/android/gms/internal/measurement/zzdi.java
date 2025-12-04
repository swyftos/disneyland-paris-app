package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class zzdi<T> implements Serializable {
    zzdi() {
    }

    public static <T> zzdi<T> zzc() {
        return zzdg.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();

    public static <T> zzdi<T> zza(T t) {
        return new zzdk(zzdh.zza(t));
    }
}
