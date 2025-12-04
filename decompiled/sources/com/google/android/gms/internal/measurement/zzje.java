package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzje implements zzdj<zzjh> {
    private static zzje zza = new zzje();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzjh) zza.zza()).zza();
    }

    private zzje(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzje() {
        this(zzdm.zza(new zzjg()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzjh zza() {
        return (zzjh) this.zzb.zza();
    }
}
