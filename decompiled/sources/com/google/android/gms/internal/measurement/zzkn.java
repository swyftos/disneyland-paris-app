package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkn implements zzdj<zzkm> {
    private static zzkn zza = new zzkn();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzkm) zza.zza()).zza();
    }

    private zzkn(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkn() {
        this(zzdm.zza(new zzkp()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzkm zza() {
        return (zzkm) this.zzb.zza();
    }
}
