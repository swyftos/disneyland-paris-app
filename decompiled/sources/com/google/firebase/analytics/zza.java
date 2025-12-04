package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
final class zza implements Callable {
    private final /* synthetic */ FirebaseAnalytics zza;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws TimeoutException {
        String strZzb = this.zza.zzb();
        if (strZzb != null) {
            return strZzb;
        }
        String strZzh = this.zza.zzb.zzh();
        if (strZzh == null) {
            throw new TimeoutException();
        }
        this.zza.zza(strZzh);
        return strZzh;
    }
}
