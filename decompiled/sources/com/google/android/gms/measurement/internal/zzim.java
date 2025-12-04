package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzim implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzii zzb;

    zzim(zzii zziiVar, long j) {
        this.zzb = zziiVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zze().zza(this.zza);
        this.zzb.zza = null;
    }
}
