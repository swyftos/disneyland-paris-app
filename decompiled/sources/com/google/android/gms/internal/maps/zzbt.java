package com.google.android.gms.internal.maps;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzbt extends zzbo {
    private final transient zzbn zza;
    private final transient zzbk zzb;

    zzbt(zzbn zzbnVar, zzbk zzbkVar) {
        this.zza = zzbnVar;
        this.zzb = zzbkVar;
    }

    @Override // com.google.android.gms.internal.maps.zzbh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.maps.zzbo, com.google.android.gms.internal.maps.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.maps.zzbh
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.maps.zzbo, com.google.android.gms.internal.maps.zzbh
    /* renamed from: zzd */
    public final zzbz iterator() {
        return this.zzb.listIterator(0);
    }
}
