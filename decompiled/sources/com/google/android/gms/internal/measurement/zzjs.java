package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzjs implements zzjt {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;

    @Override // com.google.android.gms.internal.measurement.zzjt
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjt
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjt
    public final boolean zzc() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.service.configurable_service_limits", false);
        zzb = zzdbVar.zza("measurement.client.configurable_service_limits", false);
        zzc = zzdbVar.zza("measurement.id.service.configurable_service_limits", 0L);
    }
}
