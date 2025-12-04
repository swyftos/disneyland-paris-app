package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzgf implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgd zzb;

    zzgf(zzgd zzgdVar, zzn zznVar) {
        this.zzb = zzgdVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        zzkj zzkjVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzkjVar.zzq().zzd();
        zzkjVar.zzk();
        Preconditions.checkNotEmpty(zznVar.zza);
        zzkjVar.zzc(zznVar);
    }
}
