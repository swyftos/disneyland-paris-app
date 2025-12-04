package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkb implements zzdj<zzka> {
    private static zzkb zza = new zzkb();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzka) zza.zza()).zza();
    }

    private zzkb(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkb() {
        this(zzdm.zza(new zzkd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzka zza() {
        return (zzka) this.zzb.zza();
    }
}
