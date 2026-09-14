package com.google.android.gms.maps;

/* JADX INFO: loaded from: classes3.dex */
final class zzj extends com.google.android.gms.maps.internal.zzao {
    final /* synthetic */ GoogleMap.OnMapLoadedCallback zza;

    zzj(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.zza = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zzb() {
        this.zza.onMapLoaded();
    }
}
