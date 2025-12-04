package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zziz implements Runnable {
    private final /* synthetic */ zzij zza;
    private final /* synthetic */ zzir zzb;

    zziz(zzir zzirVar, zzij zzijVar) {
        this.zzb = zzirVar;
        this.zza = zzijVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzem zzemVar = this.zzb.zzb;
        if (zzemVar == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzij zzijVar = this.zza;
            if (zzijVar == null) {
                zzemVar.zza(0L, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzemVar.zza(zzijVar.zzc, zzijVar.zza, zzijVar.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
