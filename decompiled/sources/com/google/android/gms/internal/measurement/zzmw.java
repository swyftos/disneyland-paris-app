package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmw implements zzdj<zzmz> {
    private static zzmw zza = new zzmw();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmz) zza.zza()).zza();
    }

    private zzmw(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmw() {
        this(zzdm.zza(new zzmy()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmz zza() {
        return (zzmz) this.zzb.zza();
    }
}
