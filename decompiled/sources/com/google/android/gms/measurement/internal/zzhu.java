package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzhu(zzhc zzhcVar, boolean z) {
        this.zzb = zzhcVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzc(this.zza);
    }
}
