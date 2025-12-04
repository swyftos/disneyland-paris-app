package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmd implements zzdj<zzmc> {
    private static zzmd zza = new zzmd();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmc) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmc) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmc) zza.zza()).zzc();
    }

    private zzmd(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmd() {
        this(zzdm.zza(new zzmf()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmc zza() {
        return (zzmc) this.zzb.zza();
    }
}
