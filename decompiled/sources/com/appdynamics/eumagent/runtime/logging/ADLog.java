package com.appdynamics.eumagent.runtime.logging;

import android.util.Log;
import com.appdynamics.eumagent.runtime.DontObfuscate;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;

@DontObfuscate
/* loaded from: classes2.dex */
public class ADLog {
    public static final int ERROR = 3;
    public static final int INFO = 2;
    public static final int NONE = 4;
    public static final String TAG = "AppDynamics";
    public static final int VERBOSE = 1;
    private static int agentLoggingLevel = 4;

    public static void setLoggingLevel(int i) {
        agentLoggingLevel = i;
    }

    public static void logInfo(String str) {
        if (isInfoLoggingEnabled()) {
            Log.i(TAG, str);
        }
    }

    public static void logVerbose(String str) {
        if (isVerboseLoggingEnabled()) {
            Log.i(TAG, str);
        }
    }

    public static void log(int i, String str, int i2) {
        if (isLogLevelEnabled(i)) {
            Log.i(TAG, String.format(str, Integer.valueOf(i2)));
        }
    }

    public static void log(int i, String str, Object obj) {
        if (isLogLevelEnabled(i)) {
            Log.i(TAG, String.format(str, obj));
        }
    }

    public static void log(int i, String str, Object obj, Object obj2) {
        if (isLogLevelEnabled(i)) {
            Log.i(TAG, String.format(str, obj, obj2));
        }
    }

    public static void log(int i, String str, Object obj, Object obj2, Object obj3) {
        if (isLogLevelEnabled(i)) {
            Log.i(TAG, String.format(str, obj, obj2, obj3));
        }
    }

    public static void logWarning(String str) {
        if (isInfoLoggingEnabled()) {
            Log.w(TAG, str);
        }
    }

    public static void logAppError(String str) {
        if (isInfoLoggingEnabled()) {
            Log.e(TAG, str);
        }
    }

    public static void logAppError(String str, Throwable th) {
        if (isInfoLoggingEnabled()) {
            Log.e(TAG, str, th);
        }
    }

    public static void logAgentError(String str) {
        logAgentError(str, null);
    }

    public static void logAgentError(String str, Throwable th) {
        try {
            if (isInfoLoggingEnabled()) {
                Log.e(TAG, str, th);
            }
            InstrumentationCallbacks.reportAgentError(str, th);
        } catch (Throwable unused) {
            if (isInfoLoggingEnabled()) {
                Log.e(TAG, "Error sending log message", th);
            }
        }
    }

    private static boolean isLogLevelEnabled(int i) {
        return i >= agentLoggingLevel && i < 4;
    }

    public static boolean isInfoLoggingEnabled() {
        return isLogLevelEnabled(2);
    }

    public static boolean isVerboseLoggingEnabled() {
        return isLogLevelEnabled(1);
    }
}
