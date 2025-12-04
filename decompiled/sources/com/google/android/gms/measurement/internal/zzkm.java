package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzkm implements Callable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkj zzb;

    zzkm(zzkj zzkjVar, zzn zznVar) {
        this.zzb = zzkjVar;
        this.zza = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        zzf zzfVarZzc = this.zzb.zzc(this.zza);
        if (zzfVarZzc == null) {
            this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
            return null;
        }
        return zzfVarZzc.zzd();
    }
}
