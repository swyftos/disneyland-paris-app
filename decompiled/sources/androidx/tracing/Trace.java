package androidx.tracing;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class Trace {
    private static boolean sHasAppTracingEnabled;

    public static boolean isEnabled() {
        return TraceApi29Impl.isEnabled();
    }

    public static void forceEnableAppTracing() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                if (sHasAppTracingEnabled) {
                    return;
                }
                sHasAppTracingEnabled = true;
                android.os.Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, Boolean.TRUE);
            } catch (Exception e) {
                handleException("setAppTracingAllowed", e);
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(str));
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str), i);
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i);
    }

    public static void setCounter(@NonNull String str, int i) {
        TraceApi29Impl.setCounter(truncatedTraceSectionLabel(str), i);
    }

    private static void handleException(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    private static String truncatedTraceSectionLabel(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
