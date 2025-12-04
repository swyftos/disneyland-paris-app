package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlg implements zzdj<zzlj> {
    private static zzlg zza = new zzlg();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzlj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlj) zza.zza()).zzb();
    }

    private zzlg(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzlg() {
        this(zzdm.zza(new zzli()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzlj zza() {
        return (zzlj) this.zzb.zza();
    }
}
