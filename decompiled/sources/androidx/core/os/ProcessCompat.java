package androidx.core.os;

import android.os.Process;

/* loaded from: classes.dex */
public final class ProcessCompat {
    public static boolean isApplicationUid(int i) {
        return Api24Impl.isApplicationUid(i);
    }

    static class Api24Impl {
        static boolean isApplicationUid(int i) {
            return Process.isApplicationUid(i);
        }
    }
}
