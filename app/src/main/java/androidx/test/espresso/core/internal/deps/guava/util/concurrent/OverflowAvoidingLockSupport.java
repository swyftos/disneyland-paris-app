package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
abstract class OverflowAvoidingLockSupport {
    static void parkNanos(Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, 2147483647999999999L));
    }
}
