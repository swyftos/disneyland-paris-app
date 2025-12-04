package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzma implements zzmb {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;
    private static final zzcv zzd;
    private static final zzcv zze;

    @Override // com.google.android.gms.internal.measurement.zzmb
    public final boolean zza() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    public final boolean zzb() {
        return ((Boolean) zzc.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    public final boolean zzc() {
        return ((Boolean) zzd.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzdbVar.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzdbVar.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzdbVar.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzdbVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
