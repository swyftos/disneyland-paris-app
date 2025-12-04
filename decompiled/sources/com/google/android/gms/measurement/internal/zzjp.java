package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzjp implements Runnable {
    private final /* synthetic */ zzji zza;

    zzjp(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzir.zza(this.zza.zza, (zzem) null);
        this.zza.zza.zzan();
    }
}
