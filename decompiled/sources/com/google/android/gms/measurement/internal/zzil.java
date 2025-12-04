package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final class zzil implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzij zzb;
    private final /* synthetic */ zzij zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzii zze;

    zzil(zzii zziiVar, Bundle bundle, zzij zzijVar, zzij zzijVar2, long j) {
        this.zze = zziiVar;
        this.zza = bundle;
        this.zzb = zzijVar;
        this.zzc = zzijVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
