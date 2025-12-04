package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlt implements zzlq {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;

    @Override // com.google.android.gms.internal.measurement.zzlq
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlq
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlq
    public final boolean zzc() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlq
    public final boolean zzd() {
        return ((Boolean) zzc.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.client.global_params.dev", false);
        zzb = zzdbVar.zza("measurement.service.global_params_in_payload", true);
        zzc = zzdbVar.zza("measurement.service.global_params", false);
    }
}
