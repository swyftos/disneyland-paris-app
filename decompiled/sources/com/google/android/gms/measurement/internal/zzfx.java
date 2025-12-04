package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* loaded from: classes4.dex */
final class zzfx implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzfv zzb;

    public zzfx(zzfv zzfvVar, String str) {
        this.zzb = zzfvVar;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzr().zzf().zza(this.zza, th);
    }
}
