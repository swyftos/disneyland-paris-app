package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zziy implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzir zzc;

    zziy(zzir zzirVar, Bundle bundle, zzn zznVar) {
        this.zzc = zzirVar;
        this.zza = bundle;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzem zzemVar = this.zzc.zzb;
        if (zzemVar == null) {
            this.zzc.zzr().zzf().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            zzemVar.zza(this.zza, this.zzb);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to send default event parameters to service", e);
        }
    }
}
