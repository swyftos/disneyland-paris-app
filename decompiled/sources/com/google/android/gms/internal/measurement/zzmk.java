package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmk implements zzdj<zzmn> {
    private static zzmk zza = new zzmk();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmn) zza.zza()).zza();
    }

    private zzmk(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmk() {
        this(zzdm.zza(new zzmm()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmn zza() {
        return (zzmn) this.zzb.zza();
    }
}
