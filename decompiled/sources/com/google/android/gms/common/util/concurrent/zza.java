package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: classes3.dex */
final class zza implements Runnable {
    private final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
