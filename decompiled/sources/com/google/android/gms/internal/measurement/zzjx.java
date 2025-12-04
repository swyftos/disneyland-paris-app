package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjx implements zzju {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;
    private static final zzcv zzd;

    @Override // com.google.android.gms.internal.measurement.zzju
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.sdk.dynamite.allow_remote_dynamite2", false);
        zzb = zzdbVar.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzdbVar.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzdbVar.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
