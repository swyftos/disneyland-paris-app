package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkk implements zzkl {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;
    private static final zzcv zzd;

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final boolean zzc() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final boolean zzd() {
        return ((Boolean) zzc.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final boolean zze() {
        return ((Boolean) zzd.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzdbVar.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzdbVar.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzdbVar.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
