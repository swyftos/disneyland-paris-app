package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzit implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkq zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzir zzd;

    zzit(zzir zzirVar, boolean z, zzkq zzkqVar, zzn zznVar) {
        this.zzd = zzirVar;
        this.zza = z;
        this.zzb = zzkqVar;
        this.zzc = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzem zzemVar = this.zzd.zzb;
        if (zzemVar == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
        } else {
            this.zzd.zza(zzemVar, this.zza ? null : this.zzb, this.zzc);
            this.zzd.zzak();
        }
    }
}
