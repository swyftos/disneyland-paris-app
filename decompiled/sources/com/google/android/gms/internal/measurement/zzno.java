package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzno implements zzdj<zznr> {
    private static zzno zza = new zzno();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zznr) zza.zza()).zza();
    }

    private zzno(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzno() {
        this(zzdm.zza(new zznq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zznr zza() {
        return (zznr) this.zzb.zza();
    }
}
