package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

/* loaded from: classes4.dex */
abstract class Platform {
    static boolean isInstanceOfThrowableClass(Throwable th, Class cls) {
        return cls.isInstance(th);
    }

    static void restoreInterruptIfIsInterruptedException(Throwable th) {
        Preconditions.checkNotNull(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
