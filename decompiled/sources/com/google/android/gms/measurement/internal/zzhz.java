package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhz(zzhc zzhcVar, long j) {
        this.zzb = zzhcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs().zzk.zza(this.zza);
        this.zzb.zzr().zzw().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
