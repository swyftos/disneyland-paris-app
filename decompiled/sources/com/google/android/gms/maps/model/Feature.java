package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public abstract class Feature {
    private final com.google.android.gms.internal.maps.zzr zza;

    Feature(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.zza = zzrVar;
    }

    static Feature zza(com.google.android.gms.internal.maps.zzr zzrVar) {
        Preconditions.checkNotNull(zzrVar);
        try {
            int iZzd = zzrVar.zzd();
            if (iZzd == 1) {
                return new PlaceFeature(zzrVar);
            }
            if (iZzd == 2) {
                return new DatasetFeature(zzrVar);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    @FeatureType
    public String getFeatureType() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
