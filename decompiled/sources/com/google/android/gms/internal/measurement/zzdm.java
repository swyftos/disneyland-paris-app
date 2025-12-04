package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes3.dex */
public final class zzdm {
    public static <T> zzdj<T> zza(zzdj<T> zzdjVar) {
        return ((zzdjVar instanceof zzdo) || (zzdjVar instanceof zzdl)) ? zzdjVar : zzdjVar instanceof Serializable ? new zzdl(zzdjVar) : new zzdo(zzdjVar);
    }

    public static <T> zzdj<T> zza(@NullableDecl T t) {
        return new zzdn(t);
    }
}
