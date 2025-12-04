package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgn implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgd zzc;

    zzgn(zzgd zzgdVar, zzao zzaoVar, String str) {
        this.zzc = zzgdVar;
        this.zza = zzaoVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
