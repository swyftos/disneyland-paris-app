package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkc implements zzdj<zzkf> {
    private static zzkc zza = new zzkc();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzkf) zza.zza()).zza();
    }

    private zzkc(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkc() {
        this(zzdm.zza(new zzke()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzkf zza() {
        return (zzkf) this.zzb.zza();
    }
}
