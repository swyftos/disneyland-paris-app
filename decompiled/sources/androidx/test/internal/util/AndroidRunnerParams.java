package androidx.test.internal.util;

import android.app.Instrumentation;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class AndroidRunnerParams {
    private final Bundle bundle;
    private final boolean ignoreSuiteMethods;
    private final Instrumentation instrumentation;
    private final long perTestTimeout;
    private final boolean skipExecution;

    @Deprecated
    public AndroidRunnerParams(Instrumentation instrumentation, Bundle bundle, boolean z, long j, boolean z2) {
        this.instrumentation = instrumentation;
        this.bundle = bundle;
        this.skipExecution = z;
        this.perTestTimeout = j;
        this.ignoreSuiteMethods = z2;
    }

    public AndroidRunnerParams(Instrumentation instrumentation, Bundle bundle, long j, boolean z) {
        this.instrumentation = instrumentation;
        this.bundle = bundle;
        this.skipExecution = false;
        this.perTestTimeout = j;
        this.ignoreSuiteMethods = z;
    }

    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    @Deprecated
    public boolean isSkipExecution() {
        return this.skipExecution;
    }

    public long getPerTestTimeout() {
        return this.perTestTimeout;
    }

    public boolean isIgnoreSuiteMethods() {
        return this.ignoreSuiteMethods;
    }
}
