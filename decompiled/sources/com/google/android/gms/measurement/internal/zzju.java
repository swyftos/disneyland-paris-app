package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzju implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjv zzb;

    zzju(zzjv zzjvVar, long j) {
        this.zzb = zzjvVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
