package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzke extends zzag {
    private final /* synthetic */ zzkj zza;
    private final /* synthetic */ zzkf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzke(zzkf zzkfVar, zzgu zzguVar, zzkj zzkjVar) {
        super(zzguVar);
        this.zzb = zzkfVar;
        this.zza = zzkjVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
