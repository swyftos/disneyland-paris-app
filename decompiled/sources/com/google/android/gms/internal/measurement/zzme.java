package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzme implements zzdj<zzmh> {
    private static zzme zza = new zzme();
    private final zzdj zzb;

    public static long zzb() {
        return ((zzmh) zza.zza()).zza();
    }

    private zzme(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzme() {
        this(zzdm.zza(new zzmg()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmh zza() {
        return (zzmh) this.zzb.zza();
    }
}
