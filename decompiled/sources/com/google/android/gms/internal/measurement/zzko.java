package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzko implements zzdj<zzkr> {
    private static zzko zza = new zzko();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzkr) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkr) zza.zza()).zzb();
    }

    private zzko(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzko() {
        this(zzdm.zza(new zzkq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzkr zza() {
        return (zzkr) this.zzb.zza();
    }
}
