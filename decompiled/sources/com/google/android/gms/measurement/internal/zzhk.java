package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzla;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzhk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhk(zzhc zzhcVar, long j) {
        this.zzb = zzhcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhc zzhcVar = this.zzb;
        long j = this.zza;
        zzhcVar.zzd();
        zzhcVar.zzb();
        zzhcVar.zzw();
        zzhcVar.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjv zzjvVarZzk = zzhcVar.zzk();
        zzjvVarZzk.zzd();
        zzjvVarZzk.zzb.zza();
        boolean zZzab = zzhcVar.zzy.zzab();
        zzfg zzfgVarZzs = zzhcVar.zzs();
        zzfgVarZzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzfgVarZzs.zzs().zzu.zza())) {
            zzfgVarZzs.zzu.zza(null);
        }
        if (zzla.zzb() && zzfgVarZzs.zzt().zza(zzaq.zzbv)) {
            zzfgVarZzs.zzp.zza(0L);
        }
        if (!zzfgVarZzs.zzt().zzh()) {
            zzfgVarZzs.zzc(!zZzab);
        }
        zzfgVarZzs.zzv.zza(null);
        zzfgVarZzs.zzw.zza(0L);
        zzfgVarZzs.zzx.zza(null);
        zzhcVar.zzh().zzad();
        if (zzla.zzb() && zzhcVar.zzt().zza(zzaq.zzbv)) {
            zzhcVar.zzk().zza.zza();
        }
        zzhcVar.zzc = !zZzab;
        this.zzb.zzh().zza(new AtomicReference<>());
    }
}
