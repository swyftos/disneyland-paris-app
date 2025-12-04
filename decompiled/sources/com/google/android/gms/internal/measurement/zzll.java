package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzll implements zzdj<zzlk> {
    private static zzll zza = new zzll();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzlk) zza.zza()).zza();
    }

    private zzll(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzll() {
        this(zzdm.zza(new zzln()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzlk zza() {
        return (zzlk) this.zzb.zza();
    }
}
