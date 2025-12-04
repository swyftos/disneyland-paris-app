package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzjb implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzw zzc;
    private final /* synthetic */ zzir zzd;

    zzjb(zzir zzirVar, zzao zzaoVar, String str, com.google.android.gms.internal.measurement.zzw zzwVar) {
        this.zzd = zzirVar;
        this.zza = zzaoVar;
        this.zzb = str;
        this.zzc = zzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzem zzemVar = this.zzd.zzb;
            if (zzemVar == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzemVar.zza(this.zza, this.zzb);
            this.zzd.zzak();
            this.zzd.zzp().zza(this.zzc, bArrZza);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, (byte[]) null);
        }
    }
}
