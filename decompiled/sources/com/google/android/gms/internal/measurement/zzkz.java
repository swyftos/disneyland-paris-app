package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkz implements zzdj<zzky> {
    private static zzkz zza = new zzkz();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzky) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzky) zza.zza()).zzb();
    }

    private zzkz(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkz() {
        this(zzdm.zza(new zzlb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzky zza() {
        return (zzky) this.zzb.zza();
    }
}
