package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzlc implements zzld {
    private static final zzcv zza;
    private static final zzcv zzb;
    private static final zzcv zzc;

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }

    static {
        zzdb zzdbVar = new zzdb(zzcw.zza("com.google.android.gms.measurement"));
        zza = zzdbVar.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzdbVar.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzdbVar.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }
}
