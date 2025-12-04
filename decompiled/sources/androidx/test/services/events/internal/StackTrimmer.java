package androidx.test.services.events.internal;

import android.util.Log;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public final class StackTrimmer {
    public static String getTrimmedStackTrace(Failure failure) {
        String trimmedStackTrace = Throwables.getTrimmedStackTrace(failure.getException());
        if (trimmedStackTrace.length() <= 65536) {
            return trimmedStackTrace;
        }
        Log.w("StackTrimmer", String.format("Stack trace too long, trimmed to first %s characters.", 65536));
        return String.valueOf(trimmedStackTrace.substring(0, 65536)).concat("\n");
    }
}
