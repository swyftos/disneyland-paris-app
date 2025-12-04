package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmv implements zzdj<zzmu> {
    private static zzmv zza = new zzmv();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmu) zza.zza()).zza();
    }

    private zzmv(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmv() {
        this(zzdm.zza(new zzmx()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmu zza() {
        return (zzmu) this.zzb.zza();
    }
}
