package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzas;
import com.google.android.gms.maps.model.FeatureLayer;

/* loaded from: classes4.dex */
final class zzd extends zzas {
    final /* synthetic */ FeatureLayer.StyleFactory zza;

    zzd(FeatureLayer featureLayer, FeatureLayer.StyleFactory styleFactory) {
        this.zza = styleFactory;
    }

    @Override // com.google.android.gms.internal.maps.zzat
    public final FeatureStyle zzb(com.google.android.gms.internal.maps.zzr zzrVar) {
        Feature featureZza = Feature.zza(zzrVar);
        if (featureZza == null) {
            return null;
        }
        return this.zza.getStyle(featureZza);
    }
}
