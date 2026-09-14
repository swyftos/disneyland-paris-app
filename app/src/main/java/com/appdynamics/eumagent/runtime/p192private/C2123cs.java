package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cs */
/* JADX INFO: loaded from: classes2.dex */
public final class C2123cs {

    /* JADX INFO: renamed from: a */
    public final long f817a;

    /* JADX INFO: renamed from: b */
    public final long f818b;

    public C2123cs() {
        this.f817a = SystemClock.uptimeMillis();
        this.f818b = System.currentTimeMillis();
    }

    public C2123cs(long j, long j2) {
        this.f817a = j;
        this.f818b = j2;
    }

    public final String toString() {
        return "[ uptimeMillis=" + this.f817a + ", epochTimeMillis=" + this.f818b + "]";
    }
}
