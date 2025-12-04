package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final /* synthetic */ class zzz implements Executor {
    static final Executor zza = new zzz();

    private zzz() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
