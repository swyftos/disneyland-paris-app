package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjv implements zzdj<zzju> {
    private static zzjv zza = new zzjv();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzju) zza.zza()).zza();
    }

    private zzjv(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzjv() {
        this(zzdm.zza(new zzjx()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzju zza() {
        return (zzju) this.zzb.zza();
    }
}
