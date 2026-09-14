package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture$UnsafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1405x75145c29 {
    /* JADX INFO: renamed from: m */
    public static /* synthetic */ boolean m395m(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
