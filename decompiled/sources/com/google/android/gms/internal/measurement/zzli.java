package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzli implements zzlj {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzb() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzdbVar.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzdbVar.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }
}
