package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkt implements zzdj<zzks> {
    private static zzkt zza = new zzkt();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzks) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzks) zza.zza()).zzb();
    }

    private zzkt(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkt() {
        this(zzdm.zza(new zzkv()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzks zza() {
        return (zzks) this.zzb.zza();
    }
}
