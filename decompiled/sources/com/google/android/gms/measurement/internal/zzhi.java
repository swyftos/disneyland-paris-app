package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzhi implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzhc zze;

    zzhi(zzhc zzhcVar, String str, String str2, Object obj, long j) {
        this.zze = zzhcVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
