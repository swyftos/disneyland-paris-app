package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zzkj implements zzkg {
    private static final zzcv zza = new zzdb(zzcw.zza("com.google.android.gms.measurement")).zza("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }
}
