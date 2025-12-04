package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zznc implements zzdj<zznf> {
    private static zznc zza = new zznc();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zznf) zza.zza()).zza();
    }

    private zznc(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zznc() {
        this(zzdm.zza(new zzne()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zznf zza() {
        return (zznf) this.zzb.zza();
    }
}
