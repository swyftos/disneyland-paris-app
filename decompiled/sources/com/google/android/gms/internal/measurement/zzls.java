package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzls implements zzdj<zzlv> {
    private static zzls zza = new zzls();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzlv) zza.zza()).zza();
    }

    private zzls(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzls() {
        this(zzdm.zza(new zzlu()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzlv zza() {
        return (zzlv) this.zzb.zza();
    }
}
