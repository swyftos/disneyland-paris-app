package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgk implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgd zzc;

    zzgk(zzgd zzgdVar, zzao zzaoVar, zzn zznVar) {
        this.zzc = zzgdVar;
        this.zza = zzaoVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzao zzaoVarZzb = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzaoVarZzb, this.zzb);
    }
}
