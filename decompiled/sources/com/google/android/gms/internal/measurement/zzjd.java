package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjd implements zzdj<zzjc> {
    private static zzjd zza = new zzjd();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzjc) zza.zza()).zza();
    }

    private zzjd(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzjd() {
        this(zzdm.zza(new zzjf()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzjc zza() {
        return (zzjc) this.zzb.zza();
    }
}
