package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjg implements zzjh {
    private static final zzcv zza;
    private static final zzcv zzb;

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.androidId.delete_feature", true);
        zzb = zzdbVar.zza("measurement.log_androidId_enabled", false);
    }
}
