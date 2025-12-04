package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzbj extends zzag.zzb {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzha zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbj(zzag zzagVar, com.google.android.gms.measurement.internal.zzha zzhaVar) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        for (int i = 0; i < this.zzd.zzf.size(); i++) {
            if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                Log.w(this.zzd.zzc, "OnEventListener already registered.");
                return;
            }
        }
        zzag.zzd zzdVar = new zzag.zzd(this.zzc);
        this.zzd.zzf.add(new Pair(this.zzc, zzdVar));
        this.zzd.zzm.registerOnMeasurementEventListener(zzdVar);
    }
}
