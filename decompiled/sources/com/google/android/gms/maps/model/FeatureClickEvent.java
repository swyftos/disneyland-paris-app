package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class FeatureClickEvent {
    private final com.google.android.gms.internal.maps.zzo zza;

    public FeatureClickEvent(com.google.android.gms.internal.maps.zzo zzoVar) {
        this.zza = (com.google.android.gms.internal.maps.zzo) Preconditions.checkNotNull(zzoVar);
    }

    @NonNull
    public List<Feature> getFeatures() {
        try {
            List listZze = this.zza.zze();
            ArrayList arrayList = new ArrayList(listZze.size());
            Iterator it = listZze.iterator();
            while (it.hasNext()) {
                Feature featureZza = Feature.zza(com.google.android.gms.internal.maps.zzq.zzb((IBinder) it.next()));
                if (featureZza != null) {
                    arrayList.add(featureZza);
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public LatLng getLatLng() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
