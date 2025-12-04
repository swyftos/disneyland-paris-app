package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzga implements Runnable {
    private final /* synthetic */ zzhd zza;
    private final /* synthetic */ zzfy zzb;

    zzga(zzfy zzfyVar, zzhd zzhdVar) {
        this.zzb = zzfyVar;
        this.zza = zzhdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
