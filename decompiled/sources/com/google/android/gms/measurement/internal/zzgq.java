package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgd zze;

    zzgq(zzgd zzgdVar, String str, String str2, String str3, long j) {
        this.zze = zzgdVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzij) null);
        } else {
            this.zze.zza.zzs().zzv().zza(this.zzb, new zzij(this.zzc, str, this.zzd));
        }
    }
}
