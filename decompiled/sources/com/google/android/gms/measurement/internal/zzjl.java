package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzjl implements Runnable {
    private final /* synthetic */ zzem zza;
    private final /* synthetic */ zzji zzb;

    zzjl(zzji zzjiVar, zzem zzemVar) {
        this.zzb = zzjiVar;
        this.zza = zzemVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            try {
                zzji.zza(this.zzb, false);
                if (!this.zzb.zza.zzab()) {
                    this.zzb.zza.zzr().zzx().zza("Connected to service");
                    this.zzb.zza.zza(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
