package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes4.dex */
final class zzjk implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzji zzb;

    zzjk(zzji zzjiVar, ComponentName componentName) {
        this.zzb = zzjiVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
