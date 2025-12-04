package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlm implements zzdj<zzlp> {
    private static zzlm zza = new zzlm();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzlp) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlp) zza.zza()).zzb();
    }

    private zzlm(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzlm() {
        this(zzdm.zza(new zzlo()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzlp zza() {
        return (zzlp) this.zzb.zza();
    }
}
