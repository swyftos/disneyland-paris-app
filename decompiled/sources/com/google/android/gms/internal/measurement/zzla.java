package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzla implements zzdj<zzld> {
    private static zzla zza = new zzla();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzld) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzld) zza.zza()).zzb();
    }

    private zzla(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzla() {
        this(zzdm.zza(new zzlc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzld zza() {
        return (zzld) this.zzb.zza();
    }
}
