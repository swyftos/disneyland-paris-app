package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzge implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzgd zzb;

    zzge(zzgd zzgdVar, zzw zzwVar) {
        this.zzb = zzgdVar;
        this.zza = zzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
