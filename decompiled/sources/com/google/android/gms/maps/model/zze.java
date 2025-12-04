package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.FeatureLayer;

/* loaded from: classes4.dex */
final class zze extends com.google.android.gms.internal.maps.zzak {
    final /* synthetic */ FeatureLayer.OnFeatureClickListener zza;

    zze(FeatureLayer featureLayer, FeatureLayer.OnFeatureClickListener onFeatureClickListener) {
        this.zza = onFeatureClickListener;
    }

    @Override // com.google.android.gms.internal.maps.zzal
    public final void zzb(com.google.android.gms.internal.maps.zzo zzoVar) {
        this.zza.onFeatureClick(new FeatureClickEvent(zzoVar));
    }
}
