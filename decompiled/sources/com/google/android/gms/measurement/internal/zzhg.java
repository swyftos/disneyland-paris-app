package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhg implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhg(zzhc zzhcVar, long j) {
        this.zzb = zzhcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
