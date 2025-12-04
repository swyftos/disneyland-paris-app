package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzki implements Runnable {
    private final /* synthetic */ zzko zza;
    private final /* synthetic */ zzkj zzb;

    zzki(zzkj zzkjVar, zzko zzkoVar) {
        this.zzb = zzkjVar;
        this.zza = zzkoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
