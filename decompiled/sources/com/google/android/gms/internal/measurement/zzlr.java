package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlr implements zzdj<zzlq> {
    private static zzlr zza = new zzlr();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzlq) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlq) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlq) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzlq) zza.zza()).zzd();
    }

    private zzlr(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzlr() {
        this(zzdm.zza(new zzlt()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzlq zza() {
        return (zzlq) this.zzb.zza();
    }
}
