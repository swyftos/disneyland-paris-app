package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
abstract class zzag {
    private static volatile Handler zzb;
    private final zzgu zza;
    private final Runnable zzc;
    private volatile long zzd;

    zzag(zzgu zzguVar) {
        Preconditions.checkNotNull(zzguVar);
        this.zza = zzguVar;
        this.zzc = new zzaj(this, zzguVar);
    }

    public abstract void zza();

    public final void zza(long j) {
        zzc();
        if (j >= 0) {
            this.zzd = this.zza.zzm().currentTimeMillis();
            if (zzd().postDelayed(this.zzc, j)) {
                return;
            }
            this.zza.zzr().zzf().zza("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean zzb() {
        return this.zzd != 0;
    }

    final void zzc() {
        this.zzd = 0L;
        zzd().removeCallbacks(this.zzc);
    }

    private final Handler zzd() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzag.class) {
            try {
                if (zzb == null) {
                    zzb = new com.google.android.gms.internal.measurement.zzq(this.zza.zzn().getMainLooper());
                }
                handler = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    static /* synthetic */ long zza(zzag zzagVar, long j) {
        zzagVar.zzd = 0L;
        return 0L;
    }
}
