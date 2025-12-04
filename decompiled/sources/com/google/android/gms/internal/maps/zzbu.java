package com.google.android.gms.internal.maps;

import java.util.Objects;

/* loaded from: classes3.dex */
final class zzbu extends zzbk {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbu(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbc.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
