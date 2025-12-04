package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzjx implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjv zzb;

    zzjx(zzjv zzjvVar, long j) {
        this.zzb = zzjvVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
