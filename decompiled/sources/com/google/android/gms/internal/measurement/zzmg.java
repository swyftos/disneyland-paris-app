package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmg implements zzmh {
    private static final zzcv zza;
    private static final zzcv zzb;

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final long zza() {
        return ((Long) zzb.zzc()).longValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.id.max_bundles_per_iteration", 0L);
        zzb = zzdbVar.zza("measurement.max_bundles_per_iteration", 2L);
    }
}
