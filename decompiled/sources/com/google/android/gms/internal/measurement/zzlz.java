package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlz implements zzlw {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;
    private static final zzcv zzd;
    private static final zzcv zze;

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zza() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzb() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzc() {
        return ((Boolean) zzc.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzd() {
        return ((Boolean) zzd.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzdbVar.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzdbVar.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzdbVar.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzdbVar.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }
}
