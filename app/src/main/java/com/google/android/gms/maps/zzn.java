package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Circle;

/* JADX INFO: loaded from: classes3.dex */
final class zzn extends com.google.android.gms.maps.internal.zzw {
    final /* synthetic */ GoogleMap.OnCircleClickListener zza;

    zzn(GoogleMap googleMap, GoogleMap.OnCircleClickListener onCircleClickListener) {
        this.zza = onCircleClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzx
    public final void zzb(com.google.android.gms.internal.maps.zzn zznVar) {
        this.zza.onCircleClick(new Circle(zznVar));
    }
}
