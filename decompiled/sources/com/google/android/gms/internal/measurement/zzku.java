package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzku implements zzdj<zzkx> {
    private static zzku zza = new zzku();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzkx) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkx) zza.zza()).zzb();
    }

    private zzku(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzku() {
        this(zzdm.zza(new zzkw()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzkx zza() {
        return (zzkx) this.zzb.zza();
    }
}
