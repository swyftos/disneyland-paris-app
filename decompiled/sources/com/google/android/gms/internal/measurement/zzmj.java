package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmj implements zzdj<zzmi> {
    private static zzmj zza = new zzmj();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzmi) zza.zza()).zza();
    }

    private zzmj(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzmj() {
        this(zzdm.zza(new zzml()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzmi zza() {
        return (zzmi) this.zzb.zza();
    }
}
