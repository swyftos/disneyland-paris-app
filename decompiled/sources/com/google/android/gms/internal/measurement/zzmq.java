package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmq implements zzdj<zzmt> {
    private static zzmq zza = new zzmq();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmt) zza.zza()).zza();
    }

    private zzmq(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmq() {
        this(zzdm.zza(new zzms()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmt zza() {
        return (zzmt) this.zzb.zza();
    }
}
