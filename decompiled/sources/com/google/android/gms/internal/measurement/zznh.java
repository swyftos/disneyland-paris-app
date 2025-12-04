package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zznh implements zzdj<zzng> {
    private static zznh zza = new zznh();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzng) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzng) zza.zza()).zzb();
    }

    private zznh(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zznh() {
        this(zzdm.zza(new zznj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzng zza() {
        return (zzng) this.zzb.zza();
    }
}
