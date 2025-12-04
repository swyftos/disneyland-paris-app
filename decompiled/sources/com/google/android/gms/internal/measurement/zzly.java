package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzly implements zzdj<zzmb> {
    private static zzly zza = new zzly();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmb) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmb) zza.zza()).zzc();
    }

    private zzly(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzly() {
        this(zzdm.zza(new zzma()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmb zza() {
        return (zzmb) this.zzb.zza();
    }
}
