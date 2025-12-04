package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzis implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzir zzd;

    zzis(zzir zzirVar, AtomicReference atomicReference, zzn zznVar, boolean z) {
        this.zzd = zzirVar;
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzem zzemVar;
        synchronized (this.zza) {
            try {
                try {
                    zzemVar = this.zzd.zzb;
                } catch (RemoteException e) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e);
                }
                if (zzemVar == null) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                this.zza.set(zzemVar.zza(this.zzb, this.zzc));
                this.zzd.zzak();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
