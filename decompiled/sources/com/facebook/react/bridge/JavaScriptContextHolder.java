package com.facebook.react.bridge;

import androidx.annotation.GuardedBy;

/* loaded from: classes3.dex */
public class JavaScriptContextHolder {

    @GuardedBy("this")
    private long mContext;

    public JavaScriptContextHolder(long j) {
        this.mContext = j;
    }

    @GuardedBy("this")
    public long get() {
        return this.mContext;
    }

    public synchronized void clear() {
        this.mContext = 0L;
    }
}
