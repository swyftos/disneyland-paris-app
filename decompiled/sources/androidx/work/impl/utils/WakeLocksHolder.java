package androidx.work.impl.utils;

import java.util.WeakHashMap;

/* loaded from: classes2.dex */
final class WakeLocksHolder {
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();
    private static final WeakHashMap wakeLocks = new WeakHashMap();

    private WakeLocksHolder() {
    }

    public final WeakHashMap getWakeLocks() {
        return wakeLocks;
    }
}
