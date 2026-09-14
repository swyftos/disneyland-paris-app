package androidx.camera.core;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Logger {
    private static int sMinLogLevel = 3;

    private static String truncateTag(String str) {
        return str;
    }

    private static boolean isLogLevelEnabled(String str, int i) {
        return sMinLogLevel <= i || Log.isLoggable(str, i);
    }

    static void setMinLogLevel(int i) {
        sMinLogLevel = i;
    }

    static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static boolean isVerboseEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 2);
    }

    public static boolean isDebugEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 3);
    }

    public static boolean isInfoEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 4);
    }

    public static boolean isWarnEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 5);
    }

    public static boolean isErrorEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 6);
    }

    /* JADX INFO: renamed from: d */
    public static void m28d(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 3)) {
            Log.d(strTruncateTag, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m29d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 3)) {
            Log.d(strTruncateTag, str2, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m32i(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 4)) {
            Log.i(strTruncateTag, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m33i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 4)) {
            Log.i(strTruncateTag, str2, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m34w(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 5)) {
            Log.w(strTruncateTag, str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m35w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 5)) {
            Log.w(strTruncateTag, str2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m30e(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 6)) {
            Log.e(strTruncateTag, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m31e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 6)) {
            Log.e(strTruncateTag, str2, th);
        }
    }
}
