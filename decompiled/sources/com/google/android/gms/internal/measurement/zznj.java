package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
public final class zznj implements zzng {
    private static final zzcv zza = new zzdb(zzcw.zza("com.google.android.gms.measurement")).zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzng
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    public final boolean zzb() {
        return ((Boolean) zza.zzc()).booleanValue();
    }
}
