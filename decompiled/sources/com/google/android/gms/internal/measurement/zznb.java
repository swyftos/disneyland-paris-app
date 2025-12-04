package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zznb implements zzdj<zzna> {
    private static zznb zza = new zznb();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzna) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzna) zza.zza()).zzb();
    }

    private zznb(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zznb() {
        this(zzdm.zza(new zznd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzna zza() {
        return (zzna) this.zzb.zza();
    }
}
