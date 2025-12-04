package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjq implements zzdj<zzjt> {
    private static zzjq zza = new zzjq();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzjt) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjt) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzjt) zza.zza()).zzc();
    }

    private zzjq(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzjq() {
        this(zzdm.zza(new zzjs()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzjt zza() {
        return (zzjt) this.zzb.zza();
    }
}
