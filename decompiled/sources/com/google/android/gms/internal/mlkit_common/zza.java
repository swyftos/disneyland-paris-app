package com.google.android.gms.internal.mlkit_common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public final class zza extends Handler {
    public zza() {
        Looper.getMainLooper();
    }

    public zza(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
