package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzaj implements Runnable {
    private final /* synthetic */ zzgu zza;
    private final /* synthetic */ zzag zzb;

    zzaj(zzag zzagVar, zzgu zzguVar) {
        this.zzb = zzagVar;
        this.zza = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zza.zzu();
        if (zzx.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zZzb = this.zzb.zzb();
        zzag.zza(this.zzb, 0L);
        if (zZzb) {
            this.zzb.zza();
        }
    }
}
