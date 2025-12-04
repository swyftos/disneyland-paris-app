package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzfh implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfe zzb;

    zzfh(zzfe zzfeVar, boolean z) {
        this.zzb = zzfeVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
