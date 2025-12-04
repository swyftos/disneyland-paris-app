package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgp implements Runnable {
    private final /* synthetic */ zzkq zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgd zzc;

    zzgp(zzgd zzgdVar, zzkq zzkqVar, zzn zznVar) {
        this.zzc = zzgdVar;
        this.zza = zzkqVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
