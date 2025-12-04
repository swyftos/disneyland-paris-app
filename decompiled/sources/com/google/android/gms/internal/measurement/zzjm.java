package com.google.android.gms.internal.measurement;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes3.dex */
public final class zzjm implements zzjn {
    private static final zzcv zza;
    private static final zzcv zzb;

    @Override // com.google.android.gms.internal.measurement.zzjn
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjn
    public final long zzb() {
        return ((Long) zzb.zzc()).longValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.sdk.attribution.cache", true);
        zzb = zzdbVar.zza("measurement.sdk.attribution.cache.ttl", CoreConstants.MILLIS_IN_ONE_WEEK);
    }
}
