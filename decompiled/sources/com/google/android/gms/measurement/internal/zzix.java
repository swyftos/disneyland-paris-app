package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzix implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzw zzb;
    private final /* synthetic */ zzir zzc;

    zzix(zzir zzirVar, zzn zznVar, com.google.android.gms.internal.measurement.zzw zzwVar) {
        this.zzc = zzirVar;
        this.zza = zznVar;
        this.zzb = zzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzem zzemVar = this.zzc.zzb;
            if (zzemVar == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String strZzc = zzemVar.zzc(this.zza);
            if (strZzc != null) {
                this.zzc.zzf().zza(strZzc);
                this.zzc.zzs().zzj.zza(strZzc);
            }
            this.zzc.zzak();
            this.zzc.zzp().zza(this.zzb, strZzc);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
