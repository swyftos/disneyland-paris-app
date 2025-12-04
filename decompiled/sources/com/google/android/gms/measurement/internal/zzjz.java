package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final class zzjz implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzjw zzc;

    zzjz(zzjw zzjwVar, long j, long j2) {
        this.zzc = zzjwVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zza.zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzjy
            private final zzjz zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                zzjz zzjzVar = this.zza;
                zzjw zzjwVar = zzjzVar.zzc;
                long j = zzjzVar.zza;
                long j2 = zzjzVar.zzb;
                zzjwVar.zza.zzd();
                zzjwVar.zza.zzr().zzw().zza("Application going to the background");
                boolean z = true;
                if (zzjwVar.zza.zzt().zza(zzaq.zzcc)) {
                    zzjwVar.zza.zzs().zzr.zza(true);
                }
                Bundle bundle = new Bundle();
                if (!zzjwVar.zza.zzt().zzj().booleanValue()) {
                    zzjwVar.zza.zzb.zzb(j2);
                    if (zzjwVar.zza.zzt().zza(zzaq.zzbr)) {
                        bundle.putLong("_et", zzjwVar.zza.zza(j2));
                        zzii.zza(zzjwVar.zza.zzi().zza(true), bundle, true);
                    } else {
                        z = false;
                    }
                    zzjwVar.zza.zza(false, z, j2);
                }
                zzjwVar.zza.zzf().zza("auto", "_ab", j, bundle);
            }
        });
    }
}
