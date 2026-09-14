package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: loaded from: classes3.dex */
final class zzr extends zzbe {
    final /* synthetic */ GoogleMap.OnPoiClickListener zza;

    zzr(GoogleMap googleMap, GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.zza = onPoiClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbf
    public final void zzb(PointOfInterest pointOfInterest) {
        this.zza.onPoiClick(pointOfInterest);
    }
}
