package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final class zzkd {
    final /* synthetic */ zzjv zza;

    zzkd(zzjv zzjvVar) {
        this.zza = zzjvVar;
    }

    final void zza() {
        this.zza.zzd();
        if (this.zza.zzs().zza(this.zza.zzm().currentTimeMillis())) {
            this.zza.zzs().zzm.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzr().zzx().zza("Detected application was in foreground");
                zzb(this.zza.zzm().currentTimeMillis(), false);
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzd();
        this.zza.zzab();
        if (this.zza.zzs().zza(j)) {
            this.zza.zzs().zzm.zza(true);
        }
        this.zza.zzs().zzp.zza(j);
        if (this.zza.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zza.zzd();
        if (this.zza.zzy.zzab()) {
            this.zza.zzs().zzp.zza(j);
            this.zza.zzr().zzx().zza("Session started, time", Long.valueOf(this.zza.zzm().elapsedRealtime()));
            long j2 = j / 1000;
            this.zza.zzf().zza("auto", "_sid", Long.valueOf(j2), j);
            this.zza.zzs().zzm.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            if (this.zza.zzt().zza(zzaq.zzbp) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.zza.zzf().zza("auto", "_s", j, bundle);
            if (com.google.android.gms.internal.measurement.zzkh.zzb() && this.zza.zzt().zza(zzaq.zzbu)) {
                String strZza = this.zza.zzs().zzu.zza();
                if (TextUtils.isEmpty(strZza)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strZza);
                this.zza.zzf().zza("auto", "_ssr", j, bundle2);
            }
        }
    }
}
