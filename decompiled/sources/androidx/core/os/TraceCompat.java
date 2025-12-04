package androidx.core.os;

import android.os.Trace;

@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {
    public static boolean isEnabled() {
        return Api29Impl.isEnabled();
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static void beginAsyncSection(String str, int i) {
        Api29Impl.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(String str, int i) {
        Api29Impl.endAsyncSection(str, i);
    }

    public static void setCounter(String str, int i) {
        Api29Impl.setCounter(str, i);
    }

    static class Api29Impl {
        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void endAsyncSection(String str, int i) {
            Trace.endAsyncSection(str, i);
        }

        static void beginAsyncSection(String str, int i) {
            Trace.beginAsyncSection(str, i);
        }

        static void setCounter(String str, long j) {
            Trace.setCounter(str, j);
        }
    }
}
