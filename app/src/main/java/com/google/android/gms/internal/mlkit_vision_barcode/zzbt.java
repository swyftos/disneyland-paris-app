package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class zzbt extends zzdh {
    final /* synthetic */ zzbv zza;

    zzbt(zzbv zzbvVar) {
        this.zza = zzbvVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh
    final zzdg zza() {
        return this.zza;
    }
}
