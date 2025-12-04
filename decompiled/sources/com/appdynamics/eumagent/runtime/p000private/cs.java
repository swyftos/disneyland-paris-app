package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class cs {
    public final long a;
    public final long b;

    public cs() {
        this.a = SystemClock.uptimeMillis();
        this.b = System.currentTimeMillis();
    }

    public cs(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final String toString() {
        return "[ uptimeMillis=" + this.a + ", epochTimeMillis=" + this.b + "]";
    }
}
