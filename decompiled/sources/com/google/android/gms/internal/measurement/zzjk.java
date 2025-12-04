package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjk implements zzdj<zzjn> {
    private static zzjk zza = new zzjk();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzjn) zza.zza()).zza();
    }

    public static long zzc() {
        return ((zzjn) zza.zza()).zzb();
    }

    private zzjk(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzjk() {
        this(zzdm.zza(new zzjm()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzjn zza() {
        return (zzjn) this.zzb.zza();
    }
}
