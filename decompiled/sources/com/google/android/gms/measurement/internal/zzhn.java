package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhn implements Runnable {
    private final /* synthetic */ zzhb zza;
    private final /* synthetic */ zzhc zzb;

    zzhn(zzhc zzhcVar, zzhb zzhbVar) {
        this.zzb = zzhcVar;
        this.zza = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
