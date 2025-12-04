package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzjt implements Runnable {
    private final /* synthetic */ zzkj zza;
    private final /* synthetic */ Runnable zzb;

    zzjt(zzjo zzjoVar, zzkj zzkjVar, Runnable runnable) {
        this.zza = zzkjVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
