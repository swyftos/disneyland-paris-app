package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgt implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgd zzc;

    zzgt(zzgd zzgdVar, zzw zzwVar, zzn zznVar) {
        this.zzc = zzgdVar;
        this.zza = zzwVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
