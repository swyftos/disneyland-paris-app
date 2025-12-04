package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;

/* loaded from: classes3.dex */
final class zzbi extends zzag.zzb {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzha zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbi(zzag zzagVar, com.google.android.gms.measurement.internal.zzha zzhaVar) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else {
                if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                    pair = (Pair) this.zzd.zzf.get(i);
                    break;
                }
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
        } else {
            this.zzd.zzm.unregisterOnMeasurementEventListener((zzab) pair.second);
            this.zzd.zzf.remove(pair);
        }
    }
}
