package com.google.android.gms.internal.maps;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzbs extends zzbo {
    private final transient zzbn zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzbs(zzbn zzbnVar, Object[] objArr, int i, int i2) {
        this.zza = zzbnVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.maps.zzbh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.maps.zzbo, com.google.android.gms.internal.maps.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzbh
    final int zza(Object[] objArr, int i) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.maps.zzbo, com.google.android.gms.internal.maps.zzbh
    /* renamed from: zzd */
    public final zzbz iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.maps.zzbo
    final zzbk zzh() {
        return new zzbr(this);
    }
}
