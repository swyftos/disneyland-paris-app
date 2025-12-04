package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes4.dex */
final class zzjm implements Runnable {
    private final /* synthetic */ zzji zza;

    zzjm(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzir zzirVar = this.zza.zza;
        Context contextZzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzirVar.zza(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
