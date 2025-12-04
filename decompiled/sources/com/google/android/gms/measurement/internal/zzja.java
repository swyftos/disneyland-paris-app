package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzja extends zzag {
    private final /* synthetic */ zzir zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzja(zzir zzirVar, zzgu zzguVar) {
        super(zzguVar);
        this.zza = zzirVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    public final void zza() {
        this.zza.zzr().zzi().zza("Tasks have been queued for a long time");
    }
}
