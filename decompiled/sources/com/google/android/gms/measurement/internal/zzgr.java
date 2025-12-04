package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgr implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgd zzb;

    zzgr(zzgd zzgdVar, zzn zznVar) {
        this.zzb = zzgdVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
