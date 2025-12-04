package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjj implements zzdj<zzji> {
    private static zzjj zza = new zzjj();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzji) zza.zza()).zza();
    }

    private zzjj(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzjj() {
        this(zzdm.zza(new zzjl()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzji zza() {
        return (zzji) this.zzb.zza();
    }
}
