package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlf implements zzdj<zzle> {
    private static zzlf zza = new zzlf();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzle) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzle) zza.zza()).zzb();
    }

    private zzlf(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzlf() {
        this(zzdm.zza(new zzlh()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzle zza() {
        return (zzle) this.zzb.zza();
    }
}
