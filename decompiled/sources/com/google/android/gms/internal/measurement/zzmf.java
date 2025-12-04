package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzmf implements zzmc {
    private static final zzcv zza;
    private static final zzcv zzb;

    @Override // com.google.android.gms.internal.measurement.zzmc
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    public final boolean zzc() {
        return ((Boolean) zzb.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzdbVar.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
    }
}
