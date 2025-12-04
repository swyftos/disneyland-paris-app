package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkh implements zzdj<zzkg> {
    private static zzkh zza = new zzkh();
    private final zzdj zzb;

    public static boolean zzb() {
        return ((zzkg) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkg) zza.zza()).zzb();
    }

    private zzkh(zzdj zzdjVar) {
        this.zzb = zzdm.zza(zzdjVar);
    }

    public zzkh() {
        this(zzdm.zza(new zzkj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final /* synthetic */ zzkg zza() {
        return (zzkg) this.zzb.zza();
    }
}
